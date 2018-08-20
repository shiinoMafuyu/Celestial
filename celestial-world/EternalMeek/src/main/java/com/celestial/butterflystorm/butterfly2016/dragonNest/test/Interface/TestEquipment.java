package com.celestial.butterflystorm.butterfly2016.dragonNest.test.Interface;

import java.util.List;

import com.celestial.agniRadiance.entity.FileReader;
import com.celestial.butterflystorm.butterfly2016.dragonNest.Interface.Equipment;
import com.celestial.butterflystorm.butterfly2016.dragonNest.impl.EquipmentImpl;
import com.celestial.butterflystorm.butterfly2016.dragonNest.other.Config;

import junit.framework.TestCase;

public class TestEquipment extends TestCase {
	String path = "src/com/dragonNest/other/equipment/灿烂的阿尔杰塔戒指/灿烂的阿尔杰塔戒指.txt";
	
	public void testBuild() {
		FileReader f = new FileReader(path);
		List<List<String>> l = f.selectAllLineBetweenRegexList(Config.SEPARATE_REGEX_WORD, Config.SEPARATE_REGEX_WORD);
		/*for(List<String> li :l){
			Util_Collection.print(li);
		}*/
		Equipment et = new EquipmentImpl(l.get(0));
		String s = et.showMsg();
		assert(s != null);
		assertEquals(2,et.MapProperty().size());
		assertEquals(5,et.MapPropertyMul().size());
		assertEquals(4,et.MapPropertyFixedPCT().size());
	}
}
