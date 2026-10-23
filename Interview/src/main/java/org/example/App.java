package org.example;

import org.example.tesco.Interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] a = {1, 2, 3};
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        System.out.println(list);
        System.out.println( "Hello World!" );
    }
}




//Start Typing here
//
//
//Vehicles :
//vehicleId
//        vehicleType //Bike, Scooter
//status //Available, Rented, Inactive, Maintenance
//onboarded:
//
//VehiclesRepo
//- addVehicle()
//- retireVehicle()
//- updateStatus()
//
//
//Specifications
//        vehicleId
//specKey : size/fuelTye/color/brand
//specValue : medium
//
//        SpecRepo
//- addSpec()
//- updateSpec()
//- deleteSpec()
//
//vehicleCharges
//        chargeId
//vehicleId
//        dailyCharge
//
//VehicleRepo
//- updateCharges()
//
//customers:
//customerId
//        name
//phone
//        email
//dob:
//        - addCustomer()
//- updateCustomer()
//
//
//wallet:
//walletId
//        customerId
//amount //(minimum balance check)
//
//        RentBook
//rentId
//        customerId
//vehicleId
//        startTimestamp
//endTimestamp
//        status //completed, ongoing
//totalAmount
//
//        RentTransactions
//transactionId
//        rentId
//paidAmount
//        remark
//
//
//
//
//vehicleCharges
//| 1:1
//Vehicles  -(1:m) Specifications
//| n*m
//RentBook -(1:m) RentTransactions
//| n*m
//customers -(1:1) wallet
//
//
//
//Package hirarchy
//controllers - service - VehicleRepo - DB
//
//
//
//
//
//

