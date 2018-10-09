package climateZones;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.Math;
import org.junit.jupiter.api.Test;

class testMaths
{
	int climateZoneHeight = 3200;
	int[] testCases = new int[] {-2, 200, 400, 600, 1800, -4800};
	int[] zoneTest = new int[6];
	int[] results = new int[] {0, 1, 2, 3, 1, 0};
	
	@Test
	void test() 
	{
		for (int i = 0; i < 6; i++)
		{
			int chunkVal = Math.abs(testCases[i] * 16);
		    int offset = (int) Math.floor(chunkVal / 25600);
		    int bandNum = (int) Math.floor(chunkVal / climateZoneHeight);
		    int trueOffset = offset * 8;
			int zone = bandNum - trueOffset;
			zoneTest[i] = zone;
		}
		
		assertTrue(zoneTest[0] == results[0]);
		assertTrue(zoneTest[1] == results[1]);
		assertTrue(zoneTest[2] == results[2]);
		assertTrue(zoneTest[3] == results[3]);
		assertTrue(zoneTest[4] == results[4]);
		assertTrue(zoneTest[5] == results[5]);
	}

}
