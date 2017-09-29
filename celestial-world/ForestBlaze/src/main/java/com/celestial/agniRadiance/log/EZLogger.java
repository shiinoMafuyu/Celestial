package com.celestial.agniRadiance.log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class EZLogger
{
  private Logger logger;

  public EZLogger(String name)
  {
    this.logger = Logger.getLogger(name);
  }

  public Logger getLogger()
  {
    return this.logger;
  }

  public Level getLevel()
  {
    return this.logger.getLevel();
  }

  public void setLevel(Level level)
  {
    this.logger.setLevel(level);
  }

  public void debug(Object message)
  {
    if (!this.logger.isDebugEnabled()) {
      return;
    }
    this.logger.debug(getCaller(new Object[] { message }));
  }

  public void debug(Object message, Throwable t)
  {
    if (!this.logger.isDebugEnabled()) {
      return;
    }
    this.logger.debug(getCaller(new Object[] { message }), t);
  }

  public void info(Object message)
  {
    if (!this.logger.isInfoEnabled()) {
      return;
    }
    this.logger.info(getCaller(new Object[] { message }));
  }

  public void info(Object message, Throwable t)
  {
    if (!this.logger.isInfoEnabled()) {
      return;
    }
    this.logger.info(getCaller(new Object[] { message }), t);
  }

  public void slightWarn(Object message)
  {
    this.logger.warn(getCaller(new Object[] { "[slight] ", message }));
  }

  public void slightWarn(Object message, Throwable t)
  {
    this.logger.warn(getCaller(new Object[] { "[slight] ", message }), t);
  }

  public void seriousWarn(Object message)
  {
    this.logger.warn(getCaller(new Object[] { "[serious] ", message }));
  }

  public void seriousWarn(Object message, Throwable t)
  {
    this.logger.warn(getCaller(new Object[] { "[serious] ", message }), t);
  }

  public void error(Object message)
  {
    this.logger.error(getCaller(new Object[] { message }));
  }

  public void error(Object message, Throwable t)
  {
    this.logger.error(getCaller(new Object[] { message }), t);
  }

  public void fatal(Object message)
  {
    this.logger.fatal(getCaller(new Object[] { message }));
  }

  public void fatal(Object message, Throwable t)
  {
    this.logger.fatal(getCaller(new Object[] { message }), t);
  }

  private String getCaller(Object[] objs)
  {
    Throwable t = new Throwable();

    StackTraceElement[] traces = t.getStackTrace();

    StackTraceElement trace = null;

    if (traces.length > 3)
      trace = traces[3];
    else if (traces.length > 0) {
      trace = traces[(traces.length - 1)];
    }

    StringBuilder builder = new StringBuilder();

    if (trace != null) {
      builder.append(trace.getClassName()).append(".").append(trace.getMethodName());
      if (trace.isNativeMethod())
        builder.append("(Native Method) - ");
      else if ((trace.getFileName() != null) && (trace.getLineNumber() >= 0))
        builder.append("(").append(trace.getLineNumber()).append(") - ");
      else if (trace.getFileName() != null)
        builder.append("(").append(trace.getFileName()).append(") - ");
      else {
        builder.append("(Unknown Source) - ");
      }
    }

    for (Object obj : objs) {
      builder.append(obj);
    }

    return builder.toString();
  }

  public String testGetCaller(Object[] objs)
  {
    return getCaller(objs);
  }
}