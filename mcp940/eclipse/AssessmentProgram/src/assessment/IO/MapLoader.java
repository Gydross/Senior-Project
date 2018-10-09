package assessment.IO;

import java.io.InputStream;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.evilco.mc.nbt.stream.NbtInputStream;

/**
 * Loads .mcr files for interpretation using the NBT libraries created by evilco @ Github.
 * Map regions will be assessed for climate zone accuracy as well as adherence to precipitation gradient restrictions.
 *   Assessments will be conducted on a scale out of 100 points. For each generation error, 2 points will be subtracted.
 *   Map scores may ONLY go down.
 *   
 * Region data will be summarized on a per-chunk basis, using similar mathematics found in the modified GenLayerBiome class to
 *   determine accuracy. Temperatures, climate zones, and humidity values, unique to each biome, will also be referenced 
 *   to determine the overall accuracy of the map.
 *   
 * This program is intended to be automatic, parsing through a specified directory and all subdirectories that follow established
 *   naming conventions. This will allow for multiple maps for each precipitation gradient to be stored in the same 
 *   subdirectories, then referenced on a case by case basis. Results will be output to a simple .txt file, and results will be
 *   summarized at the end of the file before the program closes I/O streams and finishes execution.
 * 
 * @author Aaron Wink
 */
public class MapLoader
{
	public MapLoader() throws FileNotFoundException
	{
	//  implement loop that progresses through directories and reads each individual .mcr file contained in each world folder
		Properties pr = new Properties();
		InputStream in = new FileInputStream("");
		
		try
		{
			pr.load(in);
			NbtInputStream nbtIn = new NbtInputStream(in);
			
			//  locate NBT tag for chunk data
			//    chunk data is stored as region data, which is the chunk coordinates shifted right five bits
			//    ex: chunk coords (x, z) = (128, 1792)
			//                         x = 128 >> 5
			//                         z = 1792 >> 5
			//        region file formatting: r.x.z.mcr, where x is the value of x above and z is the value of z above
			//        example would produce region file r.4.56.mcr
			//  
			//  read biome ID at position 0,0 in each biome array
			//    won't lose accuracy due to biomes generating as entire chunks rather than oddly shaped blobs
			//    chunks disorganized with default precipitation organization, but that is likely subject to change
			//      with stricter humidity checks
			//
			//  open an output stream and print results to output file (single line, map evaluation in overall score, number of misses,
			//    success %
			//
			//  end loop
			
		} catch(Exception ex) {
			// exception handling :D
		} finally {
			if (in != null)
				try
				{
					in.close();
				} catch(IOException ex) {
				}
		}
	}
}
