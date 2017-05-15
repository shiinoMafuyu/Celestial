package com.dn.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017-05-12
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class Strengthen{
	
	/**
	 * 矮滴 
	 */
	private Integer id ;
	/**
	 * 等级 
	 */
	private Integer level ;
	/**
	 * 物品等级 
	 */
	private String goodslevel ;
	/**
	 * 代表id 
	 */
	private String representId ;
	/**
	 * 特征名字 
	 */
	private String characterName ;
	/**
	 * 强化类型 
	 */
	private String strengthenKind ;
	/**
	 * 名字 
	 */
	private Integer name ;
	/**
	 * 强化等级 
	 */
	private Integer strengthenLevel ;
	/**
	 * 条件搜索字段用于实现递归数据结构 
	 */
	private String search ;
	/**
	 * 力量 
	 */
	private Integer li ;
	/**
	 * 敏捷 
	 */
	private Integer min ;
	/**
	 * 智力 
	 */
	private Integer zhi ;
	/**
	 * 体质 
	 */
	private Integer ti ;
	/**
	 * 物理攻击 
	 */
	private String wg ;
	/**
	 * 硬直 
	 */
	private Integer yz ;
	/**
	 * 眩晕 
	 */
	private Integer xy ;
	/**
	 * 眩晕抵抗 
	 */
	private Integer xyDK ;
	/**
	 * 致命一击 
	 */
	private Integer zm ;
	/**
	 * 致命一击抵抗 
	 */
	private Integer zmDK ;
	/**
	 * 魔法攻击 
	 */
	private String mg ;
	/**
	 * 魔法防御力 
	 */
	private Integer mf ;
	/**
	 * hp 
	 */
	private Integer hp ;
	/**
	 * 防御力 
	 */
	private Integer wf ;
	/**
	 * 硬直抵抗 
	 */
	private Integer yzDK ;
	/**
	 * 光攻 
	 */
	private Double gg ;
	/**
	 * 火攻 
	 */
	private Double hg ;
	/**
	 * 水攻 
	 */
	private Double sg ;
	/**
	 * 暗攻 
	 */
	private Double ag ;
	/**
	 * 光防 
	 */
	private Double gf ;
	/**
	 * 火防 
	 */
	private Double hf ;
	/**
	 * 水防 
	 */
	private Double sf ;
	/**
	 * 暗防 
	 */
	private Double af ;
	/**
	 * 最终伤害 
	 */
	private Integer zz ;
	/**
	 * 致命一击伤害 
	 */
	private Integer zmsh ;
	/**
	 * 移动速度 
	 */
	private Integer ydsd ;
	/**
	 * mp恢复 
	 */
	private Integer mphf ;
	/**
	 * 力量 
	 */
	private Double li_ ;
	/**
	 * 敏捷 
	 */
	private Double min_ ;
	/**
	 * 智力 
	 */
	private Double zhi_ ;
	/**
	 * 体质 
	 */
	private Double ti_ ;
	/**
	 * 物理攻击 
	 */
	private String wg_ ;
	/**
	 * 硬直 
	 */
	private Double yz_ ;
	/**
	 * 眩晕 
	 */
	private Double xy_ ;
	/**
	 * 眩晕抵抗 
	 */
	private Double xyDK_ ;
	/**
	 * 致命一击 
	 */
	private Double zm_ ;
	/**
	 * 致命一击抵抗 
	 */
	private Double zmDK_ ;
	/**
	 * 魔法攻击 
	 */
	private String mg_ ;
	/**
	 * 魔法防御力 
	 */
	private Double mf_ ;
	/**
	 * hp 
	 */
	private Double hp_ ;
	/**
	 * 防御力 
	 */
	private Double wf_ ;
	/**
	 * 硬直抵抗 
	 */
	private Double yzDK_ ;
	/**
	 * 最终伤害 
	 */
	private Double zz_ ;
	/**
	 * 致命一击伤害 
	 */
	private Double zmsh_ ;
	/**
	 * 移动速度 
	 */
	private Double ydsd_ ;
	/**
	 * mp恢复比率 
	 */
	private Double mphf_ ;
	
	public Strengthen() {
		super();
	}
	
	public Strengthen(Integer id) {
		super();
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Strengthen other = (Strengthen) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (goodslevel == null) {
			if (other.goodslevel != null)
				return false;
		} else if (!goodslevel.equals(other.goodslevel))
			return false;
		if (representId == null) {
			if (other.representId != null)
				return false;
		} else if (!representId.equals(other.representId))
			return false;
		if (characterName == null) {
			if (other.characterName != null)
				return false;
		} else if (!characterName.equals(other.characterName))
			return false;
		if (strengthenKind == null) {
			if (other.strengthenKind != null)
				return false;
		} else if (!strengthenKind.equals(other.strengthenKind))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (strengthenLevel == null) {
			if (other.strengthenLevel != null)
				return false;
		} else if (!strengthenLevel.equals(other.strengthenLevel))
			return false;
		if (search == null) {
			if (other.search != null)
				return false;
		} else if (!search.equals(other.search))
			return false;
		if (li == null) {
			if (other.li != null)
				return false;
		} else if (!li.equals(other.li))
			return false;
		if (min == null) {
			if (other.min != null)
				return false;
		} else if (!min.equals(other.min))
			return false;
		if (zhi == null) {
			if (other.zhi != null)
				return false;
		} else if (!zhi.equals(other.zhi))
			return false;
		if (ti == null) {
			if (other.ti != null)
				return false;
		} else if (!ti.equals(other.ti))
			return false;
		if (wg == null) {
			if (other.wg != null)
				return false;
		} else if (!wg.equals(other.wg))
			return false;
		if (yz == null) {
			if (other.yz != null)
				return false;
		} else if (!yz.equals(other.yz))
			return false;
		if (xy == null) {
			if (other.xy != null)
				return false;
		} else if (!xy.equals(other.xy))
			return false;
		if (xyDK == null) {
			if (other.xyDK != null)
				return false;
		} else if (!xyDK.equals(other.xyDK))
			return false;
		if (zm == null) {
			if (other.zm != null)
				return false;
		} else if (!zm.equals(other.zm))
			return false;
		if (zmDK == null) {
			if (other.zmDK != null)
				return false;
		} else if (!zmDK.equals(other.zmDK))
			return false;
		if (mg == null) {
			if (other.mg != null)
				return false;
		} else if (!mg.equals(other.mg))
			return false;
		if (mf == null) {
			if (other.mf != null)
				return false;
		} else if (!mf.equals(other.mf))
			return false;
		if (hp == null) {
			if (other.hp != null)
				return false;
		} else if (!hp.equals(other.hp))
			return false;
		if (wf == null) {
			if (other.wf != null)
				return false;
		} else if (!wf.equals(other.wf))
			return false;
		if (yzDK == null) {
			if (other.yzDK != null)
				return false;
		} else if (!yzDK.equals(other.yzDK))
			return false;
		if (gg == null) {
			if (other.gg != null)
				return false;
		} else if (!gg.equals(other.gg))
			return false;
		if (hg == null) {
			if (other.hg != null)
				return false;
		} else if (!hg.equals(other.hg))
			return false;
		if (sg == null) {
			if (other.sg != null)
				return false;
		} else if (!sg.equals(other.sg))
			return false;
		if (ag == null) {
			if (other.ag != null)
				return false;
		} else if (!ag.equals(other.ag))
			return false;
		if (gf == null) {
			if (other.gf != null)
				return false;
		} else if (!gf.equals(other.gf))
			return false;
		if (hf == null) {
			if (other.hf != null)
				return false;
		} else if (!hf.equals(other.hf))
			return false;
		if (sf == null) {
			if (other.sf != null)
				return false;
		} else if (!sf.equals(other.sf))
			return false;
		if (af == null) {
			if (other.af != null)
				return false;
		} else if (!af.equals(other.af))
			return false;
		if (zz == null) {
			if (other.zz != null)
				return false;
		} else if (!zz.equals(other.zz))
			return false;
		if (zmsh == null) {
			if (other.zmsh != null)
				return false;
		} else if (!zmsh.equals(other.zmsh))
			return false;
		if (ydsd == null) {
			if (other.ydsd != null)
				return false;
		} else if (!ydsd.equals(other.ydsd))
			return false;
		if (mphf == null) {
			if (other.mphf != null)
				return false;
		} else if (!mphf.equals(other.mphf))
			return false;
		if (li_ == null) {
			if (other.li_ != null)
				return false;
		} else if (!li_.equals(other.li_))
			return false;
		if (min_ == null) {
			if (other.min_ != null)
				return false;
		} else if (!min_.equals(other.min_))
			return false;
		if (zhi_ == null) {
			if (other.zhi_ != null)
				return false;
		} else if (!zhi_.equals(other.zhi_))
			return false;
		if (ti_ == null) {
			if (other.ti_ != null)
				return false;
		} else if (!ti_.equals(other.ti_))
			return false;
		if (wg_ == null) {
			if (other.wg_ != null)
				return false;
		} else if (!wg_.equals(other.wg_))
			return false;
		if (yz_ == null) {
			if (other.yz_ != null)
				return false;
		} else if (!yz_.equals(other.yz_))
			return false;
		if (xy_ == null) {
			if (other.xy_ != null)
				return false;
		} else if (!xy_.equals(other.xy_))
			return false;
		if (xyDK_ == null) {
			if (other.xyDK_ != null)
				return false;
		} else if (!xyDK_.equals(other.xyDK_))
			return false;
		if (zm_ == null) {
			if (other.zm_ != null)
				return false;
		} else if (!zm_.equals(other.zm_))
			return false;
		if (zmDK_ == null) {
			if (other.zmDK_ != null)
				return false;
		} else if (!zmDK_.equals(other.zmDK_))
			return false;
		if (mg_ == null) {
			if (other.mg_ != null)
				return false;
		} else if (!mg_.equals(other.mg_))
			return false;
		if (mf_ == null) {
			if (other.mf_ != null)
				return false;
		} else if (!mf_.equals(other.mf_))
			return false;
		if (hp_ == null) {
			if (other.hp_ != null)
				return false;
		} else if (!hp_.equals(other.hp_))
			return false;
		if (wf_ == null) {
			if (other.wf_ != null)
				return false;
		} else if (!wf_.equals(other.wf_))
			return false;
		if (yzDK_ == null) {
			if (other.yzDK_ != null)
				return false;
		} else if (!yzDK_.equals(other.yzDK_))
			return false;
		if (zz_ == null) {
			if (other.zz_ != null)
				return false;
		} else if (!zz_.equals(other.zz_))
			return false;
		if (zmsh_ == null) {
			if (other.zmsh_ != null)
				return false;
		} else if (!zmsh_.equals(other.zmsh_))
			return false;
		if (ydsd_ == null) {
			if (other.ydsd_ != null)
				return false;
		} else if (!ydsd_.equals(other.ydsd_))
			return false;
		if (mphf_ == null) {
			if (other.mphf_ != null)
				return false;
		} else if (!mphf_.equals(other.mphf_))
			return false;
	return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((goodslevel == null) ? 0 : goodslevel.hashCode());
		result = prime * result + ((representId == null) ? 0 : representId.hashCode());
		result = prime * result + ((characterName == null) ? 0 : characterName.hashCode());
		result = prime * result + ((strengthenKind == null) ? 0 : strengthenKind.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((strengthenLevel == null) ? 0 : strengthenLevel.hashCode());
		result = prime * result + ((search == null) ? 0 : search.hashCode());
		result = prime * result + ((li == null) ? 0 : li.hashCode());
		result = prime * result + ((min == null) ? 0 : min.hashCode());
		result = prime * result + ((zhi == null) ? 0 : zhi.hashCode());
		result = prime * result + ((ti == null) ? 0 : ti.hashCode());
		result = prime * result + ((wg == null) ? 0 : wg.hashCode());
		result = prime * result + ((yz == null) ? 0 : yz.hashCode());
		result = prime * result + ((xy == null) ? 0 : xy.hashCode());
		result = prime * result + ((xyDK == null) ? 0 : xyDK.hashCode());
		result = prime * result + ((zm == null) ? 0 : zm.hashCode());
		result = prime * result + ((zmDK == null) ? 0 : zmDK.hashCode());
		result = prime * result + ((mg == null) ? 0 : mg.hashCode());
		result = prime * result + ((mf == null) ? 0 : mf.hashCode());
		result = prime * result + ((hp == null) ? 0 : hp.hashCode());
		result = prime * result + ((wf == null) ? 0 : wf.hashCode());
		result = prime * result + ((yzDK == null) ? 0 : yzDK.hashCode());
		result = prime * result + ((gg == null) ? 0 : gg.hashCode());
		result = prime * result + ((hg == null) ? 0 : hg.hashCode());
		result = prime * result + ((sg == null) ? 0 : sg.hashCode());
		result = prime * result + ((ag == null) ? 0 : ag.hashCode());
		result = prime * result + ((gf == null) ? 0 : gf.hashCode());
		result = prime * result + ((hf == null) ? 0 : hf.hashCode());
		result = prime * result + ((sf == null) ? 0 : sf.hashCode());
		result = prime * result + ((af == null) ? 0 : af.hashCode());
		result = prime * result + ((zz == null) ? 0 : zz.hashCode());
		result = prime * result + ((zmsh == null) ? 0 : zmsh.hashCode());
		result = prime * result + ((ydsd == null) ? 0 : ydsd.hashCode());
		result = prime * result + ((mphf == null) ? 0 : mphf.hashCode());
		result = prime * result + ((li_ == null) ? 0 : li_.hashCode());
		result = prime * result + ((min_ == null) ? 0 : min_.hashCode());
		result = prime * result + ((zhi_ == null) ? 0 : zhi_.hashCode());
		result = prime * result + ((ti_ == null) ? 0 : ti_.hashCode());
		result = prime * result + ((wg_ == null) ? 0 : wg_.hashCode());
		result = prime * result + ((yz_ == null) ? 0 : yz_.hashCode());
		result = prime * result + ((xy_ == null) ? 0 : xy_.hashCode());
		result = prime * result + ((xyDK_ == null) ? 0 : xyDK_.hashCode());
		result = prime * result + ((zm_ == null) ? 0 : zm_.hashCode());
		result = prime * result + ((zmDK_ == null) ? 0 : zmDK_.hashCode());
		result = prime * result + ((mg_ == null) ? 0 : mg_.hashCode());
		result = prime * result + ((mf_ == null) ? 0 : mf_.hashCode());
		result = prime * result + ((hp_ == null) ? 0 : hp_.hashCode());
		result = prime * result + ((wf_ == null) ? 0 : wf_.hashCode());
		result = prime * result + ((yzDK_ == null) ? 0 : yzDK_.hashCode());
		result = prime * result + ((zz_ == null) ? 0 : zz_.hashCode());
		result = prime * result + ((zmsh_ == null) ? 0 : zmsh_.hashCode());
		result = prime * result + ((ydsd_ == null) ? 0 : ydsd_.hashCode());
		result = prime * result + ((mphf_ == null) ? 0 : mphf_.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "Strengthen ["

				+" id=" + id + ", "
				+" level=" + level + ", "
				+" goodslevel=" + goodslevel + ", "
				+" representId=" + representId + ", "
				+" characterName=" + characterName + ", "
				+" strengthenKind=" + strengthenKind + ", "
				+" name=" + name + ", "
				+" strengthenLevel=" + strengthenLevel + ", "
				+" search=" + search + ", "
				+" li=" + li + ", "
				+" min=" + min + ", "
				+" zhi=" + zhi + ", "
				+" ti=" + ti + ", "
				+" wg=" + wg + ", "
				+" yz=" + yz + ", "
				+" xy=" + xy + ", "
				+" xyDK=" + xyDK + ", "
				+" zm=" + zm + ", "
				+" zmDK=" + zmDK + ", "
				+" mg=" + mg + ", "
				+" mf=" + mf + ", "
				+" hp=" + hp + ", "
				+" wf=" + wf + ", "
				+" yzDK=" + yzDK + ", "
				+" gg=" + gg + ", "
				+" hg=" + hg + ", "
				+" sg=" + sg + ", "
				+" ag=" + ag + ", "
				+" gf=" + gf + ", "
				+" hf=" + hf + ", "
				+" sf=" + sf + ", "
				+" af=" + af + ", "
				+" zz=" + zz + ", "
				+" zmsh=" + zmsh + ", "
				+" ydsd=" + ydsd + ", "
				+" mphf=" + mphf + ", "
				+" li_=" + li_ + ", "
				+" min_=" + min_ + ", "
				+" zhi_=" + zhi_ + ", "
				+" ti_=" + ti_ + ", "
				+" wg_=" + wg_ + ", "
				+" yz_=" + yz_ + ", "
				+" xy_=" + xy_ + ", "
				+" xyDK_=" + xyDK_ + ", "
				+" zm_=" + zm_ + ", "
				+" zmDK_=" + zmDK_ + ", "
				+" mg_=" + mg_ + ", "
				+" mf_=" + mf_ + ", "
				+" hp_=" + hp_ + ", "
				+" wf_=" + wf_ + ", "
				+" yzDK_=" + yzDK_ + ", "
				+" zz_=" + zz_ + ", "
				+" zmsh_=" + zmsh_ + ", "
				+" ydsd_=" + ydsd_ + ", "
				+" mphf_=" + mphf_ + " "
			+ "]";
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取矮滴
	 * </ul>
	 * @return
	 */
	public Integer getId() {
		return id ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置矮滴
	 * </ul>
	 * @param id
	 */
	public Strengthen setId(Integer id) {
		this.id = id;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取等级
	 * </ul>
	 * @return
	 */
	public Integer getLevel() {
		return level ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置等级
	 * </ul>
	 * @param level
	 */
	public Strengthen setLevel(Integer level) {
		this.level = level;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取物品等级
	 * </ul>
	 * @return
	 */
	public String getGoodslevel() {
		return goodslevel ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置物品等级
	 * </ul>
	 * @param goodslevel
	 */
	public Strengthen setGoodslevel(String goodslevel) {
		this.goodslevel = goodslevel;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取代表id
	 * </ul>
	 * @return
	 */
	public String getRepresentId() {
		return representId ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置代表id
	 * </ul>
	 * @param representId
	 */
	public Strengthen setRepresentId(String representId) {
		this.representId = representId;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取特征名字
	 * </ul>
	 * @return
	 */
	public String getCharacterName() {
		return characterName ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置特征名字
	 * </ul>
	 * @param characterName
	 */
	public Strengthen setCharacterName(String characterName) {
		this.characterName = characterName;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取强化类型
	 * </ul>
	 * @return
	 */
	public String getStrengthenKind() {
		return strengthenKind ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置强化类型
	 * </ul>
	 * @param strengthenKind
	 */
	public Strengthen setStrengthenKind(String strengthenKind) {
		this.strengthenKind = strengthenKind;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取名字
	 * </ul>
	 * @return
	 */
	public Integer getName() {
		return name ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置名字
	 * </ul>
	 * @param name
	 */
	public Strengthen setName(Integer name) {
		this.name = name;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取强化等级
	 * </ul>
	 * @return
	 */
	public Integer getStrengthenLevel() {
		return strengthenLevel ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置强化等级
	 * </ul>
	 * @param strengthenLevel
	 */
	public Strengthen setStrengthenLevel(Integer strengthenLevel) {
		this.strengthenLevel = strengthenLevel;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取条件搜索字段用于实现递归数据结构
	 * </ul>
	 * @return
	 */
	public String getSearch() {
		return search ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置条件搜索字段用于实现递归数据结构
	 * </ul>
	 * @param search
	 */
	public Strengthen setSearch(String search) {
		this.search = search;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取力量
	 * </ul>
	 * @return
	 */
	public Integer getLi() {
		return li ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置力量
	 * </ul>
	 * @param li
	 */
	public Strengthen setLi(Integer li) {
		this.li = li;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取敏捷
	 * </ul>
	 * @return
	 */
	public Integer getMin() {
		return min ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置敏捷
	 * </ul>
	 * @param min
	 */
	public Strengthen setMin(Integer min) {
		this.min = min;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取智力
	 * </ul>
	 * @return
	 */
	public Integer getZhi() {
		return zhi ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置智力
	 * </ul>
	 * @param zhi
	 */
	public Strengthen setZhi(Integer zhi) {
		this.zhi = zhi;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取体质
	 * </ul>
	 * @return
	 */
	public Integer getTi() {
		return ti ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置体质
	 * </ul>
	 * @param ti
	 */
	public Strengthen setTi(Integer ti) {
		this.ti = ti;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取物理攻击
	 * </ul>
	 * @return
	 */
	public String getWg() {
		return wg ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置物理攻击
	 * </ul>
	 * @param wg
	 */
	public Strengthen setWg(String wg) {
		this.wg = wg;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取硬直
	 * </ul>
	 * @return
	 */
	public Integer getYz() {
		return yz ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置硬直
	 * </ul>
	 * @param yz
	 */
	public Strengthen setYz(Integer yz) {
		this.yz = yz;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取眩晕
	 * </ul>
	 * @return
	 */
	public Integer getXy() {
		return xy ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置眩晕
	 * </ul>
	 * @param xy
	 */
	public Strengthen setXy(Integer xy) {
		this.xy = xy;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取眩晕抵抗
	 * </ul>
	 * @return
	 */
	public Integer getXyDK() {
		return xyDK ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置眩晕抵抗
	 * </ul>
	 * @param xyDK
	 */
	public Strengthen setXyDK(Integer xyDK) {
		this.xyDK = xyDK;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取致命一击
	 * </ul>
	 * @return
	 */
	public Integer getZm() {
		return zm ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置致命一击
	 * </ul>
	 * @param zm
	 */
	public Strengthen setZm(Integer zm) {
		this.zm = zm;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取致命一击抵抗
	 * </ul>
	 * @return
	 */
	public Integer getZmDK() {
		return zmDK ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置致命一击抵抗
	 * </ul>
	 * @param zmDK
	 */
	public Strengthen setZmDK(Integer zmDK) {
		this.zmDK = zmDK;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取魔法攻击
	 * </ul>
	 * @return
	 */
	public String getMg() {
		return mg ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置魔法攻击
	 * </ul>
	 * @param mg
	 */
	public Strengthen setMg(String mg) {
		this.mg = mg;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取魔法防御力
	 * </ul>
	 * @return
	 */
	public Integer getMf() {
		return mf ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置魔法防御力
	 * </ul>
	 * @param mf
	 */
	public Strengthen setMf(Integer mf) {
		this.mf = mf;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取hp
	 * </ul>
	 * @return
	 */
	public Integer getHp() {
		return hp ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置hp
	 * </ul>
	 * @param hp
	 */
	public Strengthen setHp(Integer hp) {
		this.hp = hp;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取防御力
	 * </ul>
	 * @return
	 */
	public Integer getWf() {
		return wf ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置防御力
	 * </ul>
	 * @param wf
	 */
	public Strengthen setWf(Integer wf) {
		this.wf = wf;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取硬直抵抗
	 * </ul>
	 * @return
	 */
	public Integer getYzDK() {
		return yzDK ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置硬直抵抗
	 * </ul>
	 * @param yzDK
	 */
	public Strengthen setYzDK(Integer yzDK) {
		this.yzDK = yzDK;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取光攻
	 * </ul>
	 * @return
	 */
	public Double getGg() {
		return gg ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置光攻
	 * </ul>
	 * @param gg
	 */
	public Strengthen setGg(Double gg) {
		this.gg = gg;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取火攻
	 * </ul>
	 * @return
	 */
	public Double getHg() {
		return hg ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置火攻
	 * </ul>
	 * @param hg
	 */
	public Strengthen setHg(Double hg) {
		this.hg = hg;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取水攻
	 * </ul>
	 * @return
	 */
	public Double getSg() {
		return sg ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置水攻
	 * </ul>
	 * @param sg
	 */
	public Strengthen setSg(Double sg) {
		this.sg = sg;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取暗攻
	 * </ul>
	 * @return
	 */
	public Double getAg() {
		return ag ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置暗攻
	 * </ul>
	 * @param ag
	 */
	public Strengthen setAg(Double ag) {
		this.ag = ag;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取光防
	 * </ul>
	 * @return
	 */
	public Double getGf() {
		return gf ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置光防
	 * </ul>
	 * @param gf
	 */
	public Strengthen setGf(Double gf) {
		this.gf = gf;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取火防
	 * </ul>
	 * @return
	 */
	public Double getHf() {
		return hf ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置火防
	 * </ul>
	 * @param hf
	 */
	public Strengthen setHf(Double hf) {
		this.hf = hf;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取水防
	 * </ul>
	 * @return
	 */
	public Double getSf() {
		return sf ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置水防
	 * </ul>
	 * @param sf
	 */
	public Strengthen setSf(Double sf) {
		this.sf = sf;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取暗防
	 * </ul>
	 * @return
	 */
	public Double getAf() {
		return af ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置暗防
	 * </ul>
	 * @param af
	 */
	public Strengthen setAf(Double af) {
		this.af = af;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取最终伤害
	 * </ul>
	 * @return
	 */
	public Integer getZz() {
		return zz ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置最终伤害
	 * </ul>
	 * @param zz
	 */
	public Strengthen setZz(Integer zz) {
		this.zz = zz;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取致命一击伤害
	 * </ul>
	 * @return
	 */
	public Integer getZmsh() {
		return zmsh ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置致命一击伤害
	 * </ul>
	 * @param zmsh
	 */
	public Strengthen setZmsh(Integer zmsh) {
		this.zmsh = zmsh;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取移动速度
	 * </ul>
	 * @return
	 */
	public Integer getYdsd() {
		return ydsd ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置移动速度
	 * </ul>
	 * @param ydsd
	 */
	public Strengthen setYdsd(Integer ydsd) {
		this.ydsd = ydsd;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取mp恢复
	 * </ul>
	 * @return
	 */
	public Integer getMphf() {
		return mphf ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置mp恢复
	 * </ul>
	 * @param mphf
	 */
	public Strengthen setMphf(Integer mphf) {
		this.mphf = mphf;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取力量
	 * </ul>
	 * @return
	 */
	public Double getLi_() {
		return li_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置力量
	 * </ul>
	 * @param li_
	 */
	public Strengthen setLi_(Double li_) {
		this.li_ = li_;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取敏捷
	 * </ul>
	 * @return
	 */
	public Double getMin_() {
		return min_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置敏捷
	 * </ul>
	 * @param min_
	 */
	public Strengthen setMin_(Double min_) {
		this.min_ = min_;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取智力
	 * </ul>
	 * @return
	 */
	public Double getZhi_() {
		return zhi_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置智力
	 * </ul>
	 * @param zhi_
	 */
	public Strengthen setZhi_(Double zhi_) {
		this.zhi_ = zhi_;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取体质
	 * </ul>
	 * @return
	 */
	public Double getTi_() {
		return ti_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置体质
	 * </ul>
	 * @param ti_
	 */
	public Strengthen setTi_(Double ti_) {
		this.ti_ = ti_;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取物理攻击
	 * </ul>
	 * @return
	 */
	public String getWg_() {
		return wg_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置物理攻击
	 * </ul>
	 * @param wg_
	 */
	public Strengthen setWg_(String wg_) {
		this.wg_ = wg_;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取硬直
	 * </ul>
	 * @return
	 */
	public Double getYz_() {
		return yz_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置硬直
	 * </ul>
	 * @param yz_
	 */
	public Strengthen setYz_(Double yz_) {
		this.yz_ = yz_;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取眩晕
	 * </ul>
	 * @return
	 */
	public Double getXy_() {
		return xy_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置眩晕
	 * </ul>
	 * @param xy_
	 */
	public Strengthen setXy_(Double xy_) {
		this.xy_ = xy_;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取眩晕抵抗
	 * </ul>
	 * @return
	 */
	public Double getXyDK_() {
		return xyDK_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置眩晕抵抗
	 * </ul>
	 * @param xyDK_
	 */
	public Strengthen setXyDK_(Double xyDK_) {
		this.xyDK_ = xyDK_;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取致命一击
	 * </ul>
	 * @return
	 */
	public Double getZm_() {
		return zm_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置致命一击
	 * </ul>
	 * @param zm_
	 */
	public Strengthen setZm_(Double zm_) {
		this.zm_ = zm_;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取致命一击抵抗
	 * </ul>
	 * @return
	 */
	public Double getZmDK_() {
		return zmDK_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置致命一击抵抗
	 * </ul>
	 * @param zmDK_
	 */
	public Strengthen setZmDK_(Double zmDK_) {
		this.zmDK_ = zmDK_;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取魔法攻击
	 * </ul>
	 * @return
	 */
	public String getMg_() {
		return mg_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置魔法攻击
	 * </ul>
	 * @param mg_
	 */
	public Strengthen setMg_(String mg_) {
		this.mg_ = mg_;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取魔法防御力
	 * </ul>
	 * @return
	 */
	public Double getMf_() {
		return mf_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置魔法防御力
	 * </ul>
	 * @param mf_
	 */
	public Strengthen setMf_(Double mf_) {
		this.mf_ = mf_;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取hp
	 * </ul>
	 * @return
	 */
	public Double getHp_() {
		return hp_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置hp
	 * </ul>
	 * @param hp_
	 */
	public Strengthen setHp_(Double hp_) {
		this.hp_ = hp_;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取防御力
	 * </ul>
	 * @return
	 */
	public Double getWf_() {
		return wf_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置防御力
	 * </ul>
	 * @param wf_
	 */
	public Strengthen setWf_(Double wf_) {
		this.wf_ = wf_;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取硬直抵抗
	 * </ul>
	 * @return
	 */
	public Double getYzDK_() {
		return yzDK_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置硬直抵抗
	 * </ul>
	 * @param yzDK_
	 */
	public Strengthen setYzDK_(Double yzDK_) {
		this.yzDK_ = yzDK_;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取最终伤害
	 * </ul>
	 * @return
	 */
	public Double getZz_() {
		return zz_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置最终伤害
	 * </ul>
	 * @param zz_
	 */
	public Strengthen setZz_(Double zz_) {
		this.zz_ = zz_;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取致命一击伤害
	 * </ul>
	 * @return
	 */
	public Double getZmsh_() {
		return zmsh_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置致命一击伤害
	 * </ul>
	 * @param zmsh_
	 */
	public Strengthen setZmsh_(Double zmsh_) {
		this.zmsh_ = zmsh_;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取移动速度
	 * </ul>
	 * @return
	 */
	public Double getYdsd_() {
		return ydsd_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置移动速度
	 * </ul>
	 * @param ydsd_
	 */
	public Strengthen setYdsd_(Double ydsd_) {
		this.ydsd_ = ydsd_;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取mp恢复比率
	 * </ul>
	 * @return
	 */
	public Double getMphf_() {
		return mphf_ ;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置mp恢复比率
	 * </ul>
	 * @param mphf_
	 */
	public Strengthen setMphf_(Double mphf_) {
		this.mphf_ = mphf_;
		return this;
	}
	
}

