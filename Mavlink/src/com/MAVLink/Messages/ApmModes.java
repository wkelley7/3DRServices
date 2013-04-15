package com.MAVLink.Messages;

import java.util.ArrayList;
import java.util.List;

import com.MAVLink.Drone;
import com.MAVLink.Messages.enums.MAV_TYPE;

public enum ApmModes {
	FIXED_WING_MANUAL (0,"Manual",MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_CIRCLE (1,"Circle",MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_STABILIZE (2,"Stabilize",MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_TRAINING (3,"Training",MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_FLY_BY_WIRE_A (5,"FBW A",MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_FLY_BY_WIRE_B (6,"FBW B",MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_AUTO (10,"Auto",MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_RTL (11,"RTL",MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_LOITER (12,"Loiter",MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_GUIDED (15,"Guided",MAV_TYPE.MAV_TYPE_FIXED_WING),

	ROTOR_STABILIZE(0, "Stabilize", MAV_TYPE.MAV_TYPE_QUADROTOR), 
	ROTOR_ACRO(1,"Acro", MAV_TYPE.MAV_TYPE_QUADROTOR), 
	ROTOR_ALT_HOLD(2, "Alt Hold",MAV_TYPE.MAV_TYPE_QUADROTOR), 
	ROTOR_AUTO(3, "Auto",MAV_TYPE.MAV_TYPE_QUADROTOR), 
	ROTOR_GUIDED(4, "Guided",MAV_TYPE.MAV_TYPE_QUADROTOR), 
	ROTOR_LOITER(5, "Loiter",MAV_TYPE.MAV_TYPE_QUADROTOR), 
	ROTOR_RTL(6, "RTL",MAV_TYPE.MAV_TYPE_QUADROTOR), 
	ROTOR_CIRCLE(7, "Circle",MAV_TYPE.MAV_TYPE_QUADROTOR), 
	ROTOR_POSITION(8, "Pos Hold",MAV_TYPE.MAV_TYPE_QUADROTOR), 
	ROTOR_LAND(9, "Land",MAV_TYPE.MAV_TYPE_QUADROTOR),
	ROTOR_TOY(11, "Toy",MAV_TYPE.MAV_TYPE_QUADROTOR), 
	
	UNKNOWN(-1, "Unknown",0);
	 
	
	
	private final int number;
    private final String name;
	private final int type;
    
	ApmModes(int number,String name, int type){
		this.number = number;
		this.name = name;
		this.type = type;
	}
	
	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}
	
	public int getType() {
		return type;
	}
	
	public static ApmModes getMode(int i, int type) {
		for (ApmModes mode : ApmModes.values()) {
			if (i == mode.getNumber() & type == mode.getType()) {
				return mode;
			}
		}
		return UNKNOWN;
	}
	
	public static ApmModes getMode(String str, int type) {
		for (ApmModes mode : ApmModes.values()) {
			if (str.equals(mode.getName()) & type == mode.getType()) {
				return mode;
			}
		}
		return UNKNOWN;
	}	
	
	public static List<String> getModeList(int type) {
		List<String> modeList = new ArrayList<String>();
		
		if (Drone.isCopter(type)) {
			type = MAV_TYPE.MAV_TYPE_QUADROTOR;			
		}
		
		for (ApmModes mode : ApmModes.values()) {
			if (isValid(mode) & mode.getType() == type) {
				modeList.add(mode.getName());			
			}
		}
		return modeList;
	}

	private static boolean isValid(ApmModes mode) {
		return mode!=ApmModes.UNKNOWN;
	}

	
	
}