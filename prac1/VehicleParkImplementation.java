package prac1;

import java.util.*;

public class VehicleParkImplementation implements VehiclePark{

	private Collection infrastructure;
	// do not add more attributes. This is all you really need
	
	public VehicleParkImplementation () {
		infrastructure = new ArrayList<>(); /* COMPLETE done */
	}
	
	
	@Override
	public int numVehicles() {
		/* Returns the number of vehicles currently in the vehicle park */
		/* COMPLETE done */
		return infrastructure.size();
	}
	
	@Override
	public boolean isEmpty() {
		/* Returns true if the vehicle park is empty, false otherwise */
		/* COMPLETE done */
		return infrastructure.isEmpty();
	}


	@Override
	public int numPrivate() {
		/* Returns the number of private vehicles in the Vehicle Park */
		/* COMPLETE done */
		int n = 0;
		for(Vehicle v : infrastructure) {
			if(v instanceof PrivateVehicle) n++;
		}
		return n;
	}

	@Override
	public boolean inPark (Plate p) {
		/* Returns true if the vehicle park contains a vehicle with plate p */
		/* COMPLETE done */
		for(Vehicle v : infrastructure) {
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
		/* COMPLETE done */
		if(v == null) throw new NullPointerException();
		if(inPark(v.getPlate())) throw new AlreadyStoredException();
		infrastructure.add(v);		
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
		
		/* COMPLETE done */

		for(Object v: vehicles) {
			if(v instanceof Vehicle) {
				try {
					enter((Vehicle)v);
				} catch (AlreadyStoredException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public boolean leave(Plate p) {
		/* 
	 	Removes from VehiclePark all vehicles with Plate p
	 	Returns true if a vehicle has been removed. False otherwise
		 */
		
		/* You can take into account that Vehicle equality 
		   is based on Plate equality */
		
		/* COMPLETE done */

		for(Vehicle v : infrastructure) {
			if(v.getPlate().equals(p)) {
				infrastructure.remove(v);
				return true;
			}
		}
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
	  /* COMPLETE done */

		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

		for(Vehicle v : infrastructure) {
			if(v.getOwner().equals(owner)) {
				infrastructure.remove(v);
				vehicles.add(v);
			}
		}

		return vehicles.toArray(new Vehicle[vehicles.size()]);
		
	}

	@Override
	public boolean containsDangerousPayload() {
		/*
	 	Returns true if the VehiclePark contains any CommercialVehicle 
	 	the payload of which is dangerous. False otherwise;
		 */
		/* COMPLETE done */

		for(Vehicle v : infrastructure) {
			if(v instanceof CommercialVehicle) {
				CommercialVehicle cv = (CommercialVehicle)v;
				if(cv.containsDangerousPayload()) return true;
			}
		}
		
		return false;
	}

	
	
}
