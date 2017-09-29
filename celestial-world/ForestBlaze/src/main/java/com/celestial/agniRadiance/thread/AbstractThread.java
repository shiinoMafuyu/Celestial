/******************************************************************
 * ISocketRead.java
 * Copyright ${year} by WZG. All Rights Reserved.
 * CreateDate：2017年9月18日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.thread;

import com.celestial.agniRadiance.EzUtil.UtilNormal;
import com.celestial.agniRadiance.log.EZLogUtil;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月18日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public abstract class AbstractThread extends Thread {
	private volatile boolean stop = false;

	private long timeSpace = 200L;

	public void pleaseStop() {
		this.stop = true;
		try {
			interrupt();
		} catch (Exception e) {
			EZLogUtil.operationLogger.seriousWarn("停止[" + getClass().getName() + "]线程异常" + e);
			EZLogUtil.systemLogger.debug("", e);
		}
	}

	public void run() {
		doBeforWork();
		while (!this.stop) {
			try {
				doWork();
			} catch (Exception e) {
				doExceptionWork(e);

				doFinallyWork();
				UtilNormal.threadSleep(this.timeSpace);
			} finally {
				doFinallyWork();
				UtilNormal.threadSleep(this.timeSpace);

			}

		}

		doAfterWork();
	}

	protected void doBeforWork() {
	}

	protected void doAfterWork() {
	}

	protected void doFinallyWork() {
	}

	protected void doExceptionWork(Exception e) {
		EZLogUtil.operationLogger.error("执行[" + getClass().getName() + "]线程异常: " + e);
		EZLogUtil.systemLogger.debug("", e);
	}

	protected abstract void doWork();

	public void setTimeSpace(long timeSpace) {
		this.timeSpace = timeSpace;
	}
}