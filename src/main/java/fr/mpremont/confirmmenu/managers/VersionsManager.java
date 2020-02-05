package fr.mpremont.confirmmenu.managers;

import org.bukkit.Bukkit;

import fr.mpremont.confirmmenu.interfaces.Version;
import fr.mpremont.confirmmenu.interfaces.versions.V1_10_R1;
import fr.mpremont.confirmmenu.interfaces.versions.V1_11_R1;
import fr.mpremont.confirmmenu.interfaces.versions.V1_8_R1;
import fr.mpremont.confirmmenu.interfaces.versions.V1_8_R2;
import fr.mpremont.confirmmenu.interfaces.versions.V1_8_R3;
import fr.mpremont.confirmmenu.interfaces.versions.V1_9_R1;
import fr.mpremont.confirmmenu.interfaces.versions.V1_9_R2;

public class VersionsManager {
	
	private static String version;
	private static Version vclass;
	
	public static boolean setupVersion() {
		
		boolean result = true;
		
		try {
			
			version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
			
		}catch (ArrayIndexOutOfBoundsException e) {
			
			e.printStackTrace();
			result = false;
			
		}
		
		if(version.equals("v1_11_R1")) {
			vclass = new V1_11_R1();
		}else if(version.equals("v1_10_R1")) {
			vclass = new V1_10_R1();
		}else if(version.equals("v1_9_R2")) {
			vclass = new V1_9_R2();
		}else if(version.equals("v1_9_R1")) {
			vclass = new V1_9_R1();
		}else if(version.equals("v1_8_R3")) {
			vclass = new V1_8_R3();
		}else if(version.equals("v1_8_R2")) {
			vclass = new V1_8_R2();
		}else if(version.equals("v1_8_R1")){
			vclass = new V1_8_R1();
		}else {
			result = false;
		}
		
		return result;
		
	}
	
	public static Version use() {
		return vclass;
	}

}
