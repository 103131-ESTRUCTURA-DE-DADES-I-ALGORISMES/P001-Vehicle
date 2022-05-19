package prac1;

import java.util.*;

public class VehicleParkImplementation implements VehiclePark{

	private Collection infrastructure;
	// do not add more attributes. This is all you really need
	
	public VehicleParkImplementation () {
		infrastructure = /* COMPLETE */
	}
	
	
	@Override
	public int numVehicles() {
		/* Returns the number of vehicles currently in the vehicle park */
		/* COMPLETE done*/
		return vehicles.size();
	}
	
	@Override
	public boolean isEmpty() {
		/* Returns true if the vehicle park is empty, false otherwise */
		/* COMPLETE done*/
		return vehicles.isEmpty();
	}


	@Override
	public int numPrivate() {
		/* Returns the number of private vehicles in the Vehicle Park */
		/* COMPLETE done*/
		int n = 0;
		for(Vehicle v : vehicles) {
			if(v instanceof PrivateVehicle) n++;
		}
		return n;
	}

	@Override
	public boolean inPark (Plate p) {
		/* Returns true if the vehicle park contains a vehicle with plate p */
		/* COMPLETE */
		for(Vehicle v : vehicles) {
			if(v.getPlate().equals(p)) return true;
		}
	}
	
	@Override
	public void enter(Vehicle v) {
		/* Stores c in the VehiclePark, if possible.
		   Throws (and does not store v):
		   	- a NullPointerException if the parameter is null
		   	- a AlreadyStoredException if the VehiclePark already contains a
		   	  vehicle "like" v
		 */
		/* COMPLETE */
		if(v == null) throw new NullPointerException();
		if(inPark(v.getPlate())) throw new AlreadyStoredException();
		vehicles.add(v);		
	}

	
	
	@Override
	public int enter(Collection vehicles) {
		/* Stores in the VehiclePark the vehicles contained in the parameter
		   Beware: the parameter may contain objects that are not vehicles
		   Beware: the parameter may contain null objects
		   Beware: the parameter may contain repetition
		   
		   Returns: the number of vehicles effectively stored 
		   
		   This method does not throw exceptions
		 */
		
		/* base this methods in the previous one 
		 (make it call the previous one) */
		
		/* COMPLETE */
		
	}

	@Override
	public boolean leave(Plate p) {
		/* 
	 	Removes from VehiclePark all vehicles with Plate p
	 	Returns true if a vehicle has been removed. False otherwise
		 */
		
		/* You can take into account that Vehicle equality 
		   is based on Plate equality */
		
		/* COMPLETE */
	}

	
	@Override
	public Vehicle[] leave(String owner) {
		/* 
 		Removes from VehiclePark all vehicles that "belong" to the given owner
 		(parameter)
 		Returns an array containing all the removed vehicles. This array:
 			- has the exact length (no empty -null- positions)
 			- has length 0 if no vehicles has been removed
 			- is sorted according to the natural ordering of the vehicles (ascending)
	 */
	  /* COMPLETE */
		
	}

	@Override
	public boolean containsDangerousPayload() {
		/*
	 	Returns true if the VehiclePark contains any CommercialVehicle 
	 	the payload of which is dangerous. False otherwise;
		 */
		/* COMPLETE */
		
	}

	
	
}
