create TABLE IF NOT EXISTS feature (id bigint not null, airbags integer not null, anti_lock_brake_abs boolean, drivers_seat_memory varchar(255), electronic_brakeforce_distribution boolean, electronic_parking_bay boolean, electronic_stability_control boolean, front_fog_lamps boolean, headlight_type varchar(255), massage_seats boolean, parking_camera varchar(255), parking_sensors varchar(255), projector_headlamps boolean, traction_control boolean, ventilated_seats boolean, vehiclevariant_id bigint, primary key (id));
create TABLE IF NOT EXISTS specification (id bigint not null, boot_capacity bigint, engine_installation varchar(255), engine_type varchar(255), fuel_type_propulsion varchar(255), height_inmm bigint, kerb_weight bigint, length_inmm bigint, max_engine_power varchar(255), max_engine_torque varchar(255), price double, wheel_base_inmm bigint, width_inmm bigint, vehiclevariant_id bigint, primary key (id));
create TABLE IF NOT EXISTS userinformation (id bigint not null, user_name varchar(255), primary key (id));
create TABLE IF NOT EXISTS vehiclebrand (id bigint not null, brand_name varchar(255), primary key (id));
create TABLE IF NOT EXISTS vehiclemodel (id bigint not null, model_name varchar(255), vehiclebrand_id bigint, primary key (id));
create TABLE IF NOT EXISTS vehiclevariant (id bigint not null, variant_name varchar(255), vehiclemodel_id bigint, primary key (id));


--inserting values in vehiclebrand table
insert into vehiclebrand(id, brand_name) values (1, 'AUDI');
insert into vehiclebrand(id, brand_name) values (2, 'BMW');
insert into vehiclebrand(id, brand_name) values (3, 'TATA');
insert into vehiclebrand(id, brand_name) values (4, 'HYUNDAI');
insert into vehiclebrand(id, brand_name) values (5, 'MARUTI SUZUKI');
insert into vehiclebrand(id, brand_name) values (6, 'FORD');
insert into vehiclebrand(id, brand_name) values (7, 'HONDA');
insert into vehiclebrand(id, brand_name) values (8, 'VOLVO');
insert into vehiclebrand(id, brand_name) values (9, 'FERRARI');
insert into vehiclebrand(id, brand_name) values (10, 'LEXUS');

--inserting values in vehiclemodel table

insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(1,'A4',1);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(2,'A3',1);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(3,'A2',1);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(4,'A1',1);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(5,'X1',2);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(6,'X2',2);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(7,'X3',2);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(8,'X4',2);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(9,'NEXON',3);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(10,'PUNCH',3);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(11,'SAFARI',3);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(12,'AURA',4);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(13,'CRETA',4);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(14,'I20',4);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(15,'BALENO',5);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(16,'ALTO',5);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(17,'DZIRE',5);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(18,'ASPIRE',6);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(19,'FIGO',6);
insert into VEHICLEMODEL(id, model_name, vehiclebrand_id) values(20,'ECOSPORT',6);

--inserting values in vehiclevariant table

insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(1,'v1',1);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(2,'v2',1);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(3,'v3',1);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(4,'v4',1);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(5,'v5',1);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(6,'v1',2);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(7,'v2',2);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(8,'v3',2);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(9,'v4',2);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(10,'v5',2);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(11,'v1',3);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(12,'v2',3);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(13,'v3',3);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(14,'v4',3);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(15,'v5',3);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(16,'v1',4);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(17,'v2',4);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(18,'v3',4);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(19,'v4',4);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(20,'v5',4);
insert into VEHICLEVARIANT(id, variant_Name, vehiclemodel_id) values(21,'v1',5);

--insert values in the specification table

insert into SPECIFICATION(ID, BOOT_CAPACITY, ENGINE_INSTALLATION, ENGINE_TYPE, FUEL_TYPE_PROPULSION, HEIGHT_INMM, KERB_WEIGHT,
                          LENGTH_INMM, MAX_ENGINE_POWER, MAX_ENGINE_TORQUE, PRICE, WHEEL_BASE_INMM, WIDTH_INMM, VEHICLEVARIANT_ID)
                          values(1,550,'FRONT','4 cyls','PETROL',1598,1485,4447,'192hp','280Nm',3500000,4333,1445,1);

insert into SPECIFICATION(ID, BOOT_CAPACITY, ENGINE_INSTALLATION, ENGINE_TYPE, FUEL_TYPE_PROPULSION, HEIGHT_INMM, KERB_WEIGHT,
                          LENGTH_INMM, MAX_ENGINE_POWER, MAX_ENGINE_TORQUE, PRICE, WHEEL_BASE_INMM, WIDTH_INMM, VEHICLEVARIANT_ID)
values(2,550,'REAR','5 cyls','DIESEL',1598,1485,4447,'193hp','280Nm',2500000,4333,1445,2);

insert into SPECIFICATION(ID, BOOT_CAPACITY, ENGINE_INSTALLATION, ENGINE_TYPE, FUEL_TYPE_PROPULSION, HEIGHT_INMM, KERB_WEIGHT,
                          LENGTH_INMM, MAX_ENGINE_POWER, MAX_ENGINE_TORQUE, PRICE, WHEEL_BASE_INMM, WIDTH_INMM, VEHICLEVARIANT_ID)
values(3,550,'REAR','5 cyls','PETROL',1510,1485,4447,'191hp','281Nm',2000000,4334,1445,3);

insert into SPECIFICATION(ID, BOOT_CAPACITY, ENGINE_INSTALLATION, ENGINE_TYPE, FUEL_TYPE_PROPULSION, HEIGHT_INMM, KERB_WEIGHT,
                          LENGTH_INMM, MAX_ENGINE_POWER, MAX_ENGINE_TORQUE, PRICE, WHEEL_BASE_INMM, WIDTH_INMM, VEHICLEVARIANT_ID)
values(4,550,'FRONT','6 cyls','DIESEL',1600,1485,4447,'192hp','280Nm',3000000,4333,1445,4);

insert into SPECIFICATION(ID, BOOT_CAPACITY, ENGINE_INSTALLATION, ENGINE_TYPE, FUEL_TYPE_PROPULSION, HEIGHT_INMM, KERB_WEIGHT,
                          LENGTH_INMM, MAX_ENGINE_POWER, MAX_ENGINE_TORQUE, PRICE, WHEEL_BASE_INMM, WIDTH_INMM, VEHICLEVARIANT_ID)
values(5,554,'REAR','4 cyls','PETROL',1398,1285,4447,'192hp','280Nm',2500000,4333,1445,5);

insert into SPECIFICATION(ID, BOOT_CAPACITY, ENGINE_INSTALLATION, ENGINE_TYPE, FUEL_TYPE_PROPULSION, HEIGHT_INMM, KERB_WEIGHT,
                          LENGTH_INMM, MAX_ENGINE_POWER, MAX_ENGINE_TORQUE, PRICE, WHEEL_BASE_INMM, WIDTH_INMM, VEHICLEVARIANT_ID)
values(6,550,'FRONT','4 cyls','PETROL',1598,1485,4447,'192hp','280Nm',3500000,4333,1445,6);

insert into SPECIFICATION(ID, BOOT_CAPACITY, ENGINE_INSTALLATION, ENGINE_TYPE, FUEL_TYPE_PROPULSION, HEIGHT_INMM, KERB_WEIGHT,
                          LENGTH_INMM, MAX_ENGINE_POWER, MAX_ENGINE_TORQUE, PRICE, WHEEL_BASE_INMM, WIDTH_INMM, VEHICLEVARIANT_ID)
values(7,550,'FRONT','4 cyls','PETROL',1598,1485,4447,'192hp','280Nm',3500000,4333,1445,7);

insert into SPECIFICATION(ID, BOOT_CAPACITY, ENGINE_INSTALLATION, ENGINE_TYPE, FUEL_TYPE_PROPULSION, HEIGHT_INMM, KERB_WEIGHT,
                          LENGTH_INMM, MAX_ENGINE_POWER, MAX_ENGINE_TORQUE, PRICE, WHEEL_BASE_INMM, WIDTH_INMM, VEHICLEVARIANT_ID)
values(8,550,'FRONT','4 cyls','DIESEL',1598,1485,4447,'191hp','280Nm',3500000,4333,1445,8);

insert into SPECIFICATION(ID, BOOT_CAPACITY, ENGINE_INSTALLATION, ENGINE_TYPE, FUEL_TYPE_PROPULSION, HEIGHT_INMM, KERB_WEIGHT,
                          LENGTH_INMM, MAX_ENGINE_POWER, MAX_ENGINE_TORQUE, PRICE, WHEEL_BASE_INMM, WIDTH_INMM, VEHICLEVARIANT_ID)
values(9,550,'FRONT','4 cyls','PETROL',1598,1485,4447,'190hp','280Nm',3500000,4333,1445,9);

insert into SPECIFICATION(ID, BOOT_CAPACITY, ENGINE_INSTALLATION, ENGINE_TYPE, FUEL_TYPE_PROPULSION, HEIGHT_INMM, KERB_WEIGHT,
                          LENGTH_INMM, MAX_ENGINE_POWER, MAX_ENGINE_TORQUE, PRICE, WHEEL_BASE_INMM, WIDTH_INMM, VEHICLEVARIANT_ID)
values(10,550,'REAR','4 cyls','PETROL',1598,1485,4447,'182hp','280Nm',3500000,4333,1445,10);

insert into SPECIFICATION(ID, BOOT_CAPACITY, ENGINE_INSTALLATION, ENGINE_TYPE, FUEL_TYPE_PROPULSION, HEIGHT_INMM, KERB_WEIGHT,
                          LENGTH_INMM, MAX_ENGINE_POWER, MAX_ENGINE_TORQUE, PRICE, WHEEL_BASE_INMM, WIDTH_INMM, VEHICLEVARIANT_ID)
values(11,550,'FRONT','4 cyls','DIESEL',1598,1485,4447,'183hp','280Nm',3500000,4333,1445,11);

insert into SPECIFICATION(ID, BOOT_CAPACITY, ENGINE_INSTALLATION, ENGINE_TYPE, FUEL_TYPE_PROPULSION, HEIGHT_INMM, KERB_WEIGHT,
                          LENGTH_INMM, MAX_ENGINE_POWER, MAX_ENGINE_TORQUE, PRICE, WHEEL_BASE_INMM, WIDTH_INMM, VEHICLEVARIANT_ID)
values(12,550,'REAR','4 cyls','PETROL',1598,1485,4447,'185hp','280Nm',3500000,4333,1445,12);

insert into SPECIFICATION(ID, BOOT_CAPACITY, ENGINE_INSTALLATION, ENGINE_TYPE, FUEL_TYPE_PROPULSION, HEIGHT_INMM, KERB_WEIGHT,
                          LENGTH_INMM, MAX_ENGINE_POWER, MAX_ENGINE_TORQUE, PRICE, WHEEL_BASE_INMM, WIDTH_INMM, VEHICLEVARIANT_ID)
values(13,550,'FRONT','4 cyls','DIESEL',1598,1485,4447,'180hp','280Nm',3500000,4333,1445,13);

insert into SPECIFICATION(ID, BOOT_CAPACITY, ENGINE_INSTALLATION, ENGINE_TYPE, FUEL_TYPE_PROPULSION, HEIGHT_INMM, KERB_WEIGHT,
                          LENGTH_INMM, MAX_ENGINE_POWER, MAX_ENGINE_TORQUE, PRICE, WHEEL_BASE_INMM, WIDTH_INMM, VEHICLEVARIANT_ID)
values(14,550,'FRONT','4 cyls','PETROL',1600,1481,4447,'188hp','280Nm',3500000,4333,1445,14);

insert into SPECIFICATION(ID, BOOT_CAPACITY, ENGINE_INSTALLATION, ENGINE_TYPE, FUEL_TYPE_PROPULSION, HEIGHT_INMM, KERB_WEIGHT,
                          LENGTH_INMM, MAX_ENGINE_POWER, MAX_ENGINE_TORQUE, PRICE, WHEEL_BASE_INMM, WIDTH_INMM, VEHICLEVARIANT_ID)
values(15,552,'REAR','5 cyls','DIESEL',1200,1485,4447,'192hp','280Nm',1000000,4333,1445,15);


--Insert values in the feature table


insert into feature(ID, AIRBAGS, ANTI_LOCK_BRAKE_ABS, DRIVERS_SEAT_MEMORY, ELECTRONIC_BRAKEFORCE_DISTRIBUTION, ELECTRONIC_PARKING_BAY,
                    ELECTRONIC_STABILITY_CONTROL, FRONT_FOG_LAMPS, HEADLIGHT_TYPE, MASSAGE_SEATS, PARKING_CAMERA, PARKING_SENSORS,
                    PROJECTOR_HEADLAMPS,TRACTION_CONTROL, VENTILATED_SEATS, VEHICLEVARIANT_ID)
                    values(1,1,true,'22mb',true,false,true,false,'REAR',false,'FRONT','SENSORS',true,false,true,1);

insert into feature(ID, AIRBAGS, ANTI_LOCK_BRAKE_ABS, DRIVERS_SEAT_MEMORY, ELECTRONIC_BRAKEFORCE_DISTRIBUTION, ELECTRONIC_PARKING_BAY,
                    ELECTRONIC_STABILITY_CONTROL, FRONT_FOG_LAMPS, HEADLIGHT_TYPE, MASSAGE_SEATS, PARKING_CAMERA, PARKING_SENSORS,
                    PROJECTOR_HEADLAMPS,TRACTION_CONTROL, VENTILATED_SEATS, VEHICLEVARIANT_ID)
values(2,2,true,'22mb',true,false,true,false,'REAR',false,'FRONT','SENSORS',true,false,true,2);

insert into feature(ID, AIRBAGS, ANTI_LOCK_BRAKE_ABS, DRIVERS_SEAT_MEMORY, ELECTRONIC_BRAKEFORCE_DISTRIBUTION, ELECTRONIC_PARKING_BAY,
                    ELECTRONIC_STABILITY_CONTROL, FRONT_FOG_LAMPS, HEADLIGHT_TYPE, MASSAGE_SEATS, PARKING_CAMERA, PARKING_SENSORS,
                    PROJECTOR_HEADLAMPS,TRACTION_CONTROL, VENTILATED_SEATS, VEHICLEVARIANT_ID)
values(3,1,true,'22mb',true,false,true,false,'FRONT',false,'FRONT','SENSORS',true,false,false,3);

insert into feature(ID, AIRBAGS, ANTI_LOCK_BRAKE_ABS, DRIVERS_SEAT_MEMORY, ELECTRONIC_BRAKEFORCE_DISTRIBUTION, ELECTRONIC_PARKING_BAY,
                    ELECTRONIC_STABILITY_CONTROL, FRONT_FOG_LAMPS, HEADLIGHT_TYPE, MASSAGE_SEATS, PARKING_CAMERA, PARKING_SENSORS,
                    PROJECTOR_HEADLAMPS,TRACTION_CONTROL, VENTILATED_SEATS, VEHICLEVARIANT_ID)
values(4,1,true,'22mb',true,false,true,false,'REAR',false,'FRONT','SENSORS',false,false,true,4);

insert into feature(ID, AIRBAGS, ANTI_LOCK_BRAKE_ABS, DRIVERS_SEAT_MEMORY, ELECTRONIC_BRAKEFORCE_DISTRIBUTION, ELECTRONIC_PARKING_BAY,
                    ELECTRONIC_STABILITY_CONTROL, FRONT_FOG_LAMPS, HEADLIGHT_TYPE, MASSAGE_SEATS, PARKING_CAMERA, PARKING_SENSORS,
                    PROJECTOR_HEADLAMPS,TRACTION_CONTROL, VENTILATED_SEATS, VEHICLEVARIANT_ID)
values(5,2,true,'22mb',true,false,true,false,'REAR',false,'FRONT','SENSORS',false,false,true,5);

insert into feature(ID, AIRBAGS, ANTI_LOCK_BRAKE_ABS, DRIVERS_SEAT_MEMORY, ELECTRONIC_BRAKEFORCE_DISTRIBUTION, ELECTRONIC_PARKING_BAY,
                    ELECTRONIC_STABILITY_CONTROL, FRONT_FOG_LAMPS, HEADLIGHT_TYPE, MASSAGE_SEATS, PARKING_CAMERA, PARKING_SENSORS,
                    PROJECTOR_HEADLAMPS,TRACTION_CONTROL, VENTILATED_SEATS, VEHICLEVARIANT_ID)
values(6,1,true,'22mb',true,false,true,false,'FRONT',false,'FRONT','SENSORS',false,false,false,6);

insert into feature(ID, AIRBAGS, ANTI_LOCK_BRAKE_ABS, DRIVERS_SEAT_MEMORY, ELECTRONIC_BRAKEFORCE_DISTRIBUTION, ELECTRONIC_PARKING_BAY,
                    ELECTRONIC_STABILITY_CONTROL, FRONT_FOG_LAMPS, HEADLIGHT_TYPE, MASSAGE_SEATS, PARKING_CAMERA, PARKING_SENSORS,
                    PROJECTOR_HEADLAMPS,TRACTION_CONTROL, VENTILATED_SEATS, VEHICLEVARIANT_ID)
values(7,1,true,'23mb',true,false,true,false,'REAR',false,'FRONT','SENSORS',false,true,true,7);

insert into feature(ID, AIRBAGS, ANTI_LOCK_BRAKE_ABS, DRIVERS_SEAT_MEMORY, ELECTRONIC_BRAKEFORCE_DISTRIBUTION, ELECTRONIC_PARKING_BAY,
                    ELECTRONIC_STABILITY_CONTROL, FRONT_FOG_LAMPS, HEADLIGHT_TYPE, MASSAGE_SEATS, PARKING_CAMERA, PARKING_SENSORS,
                    PROJECTOR_HEADLAMPS,TRACTION_CONTROL, VENTILATED_SEATS, VEHICLEVARIANT_ID)
values(8,2,true,'22mb',false,false,true,true,'FRONT',false,'REAR','SENSORS',false,true,true,8);

insert into feature(ID, AIRBAGS, ANTI_LOCK_BRAKE_ABS, DRIVERS_SEAT_MEMORY, ELECTRONIC_BRAKEFORCE_DISTRIBUTION, ELECTRONIC_PARKING_BAY,
                    ELECTRONIC_STABILITY_CONTROL, FRONT_FOG_LAMPS, HEADLIGHT_TYPE, MASSAGE_SEATS, PARKING_CAMERA, PARKING_SENSORS,
                    PROJECTOR_HEADLAMPS,TRACTION_CONTROL, VENTILATED_SEATS, VEHICLEVARIANT_ID)
values(9,2,false,'24mb',true,false,true,false,'REAR',false,'FRONT','SENSORS',true,false,true,9);

insert into feature(ID, AIRBAGS, ANTI_LOCK_BRAKE_ABS, DRIVERS_SEAT_MEMORY, ELECTRONIC_BRAKEFORCE_DISTRIBUTION, ELECTRONIC_PARKING_BAY,
                    ELECTRONIC_STABILITY_CONTROL, FRONT_FOG_LAMPS, HEADLIGHT_TYPE, MASSAGE_SEATS, PARKING_CAMERA, PARKING_SENSORS,
                    PROJECTOR_HEADLAMPS,TRACTION_CONTROL, VENTILATED_SEATS, VEHICLEVARIANT_ID)
values(10,2,true,'22mb',true,false,true,false,'FRONT',false,'FRONT','SENSORS',true,false,true,10);

insert into feature(ID, AIRBAGS, ANTI_LOCK_BRAKE_ABS, DRIVERS_SEAT_MEMORY, ELECTRONIC_BRAKEFORCE_DISTRIBUTION, ELECTRONIC_PARKING_BAY,
                    ELECTRONIC_STABILITY_CONTROL, FRONT_FOG_LAMPS, HEADLIGHT_TYPE, MASSAGE_SEATS, PARKING_CAMERA, PARKING_SENSORS,
                    PROJECTOR_HEADLAMPS,TRACTION_CONTROL, VENTILATED_SEATS, VEHICLEVARIANT_ID)
values(11,2,true,'22mb',true,true,true,false,'REAR',false,'FRONT','SENSORS',true,false,true,11);

insert into feature(ID, AIRBAGS, ANTI_LOCK_BRAKE_ABS, DRIVERS_SEAT_MEMORY, ELECTRONIC_BRAKEFORCE_DISTRIBUTION, ELECTRONIC_PARKING_BAY,
                    ELECTRONIC_STABILITY_CONTROL, FRONT_FOG_LAMPS, HEADLIGHT_TYPE, MASSAGE_SEATS, PARKING_CAMERA, PARKING_SENSORS,
                    PROJECTOR_HEADLAMPS,TRACTION_CONTROL, VENTILATED_SEATS, VEHICLEVARIANT_ID)
values(12,2,true,'22mb',true,false,true,false,'REAR',false,'FRONT','SENSORS',true,false,true,12);

insert into feature(ID, AIRBAGS, ANTI_LOCK_BRAKE_ABS, DRIVERS_SEAT_MEMORY, ELECTRONIC_BRAKEFORCE_DISTRIBUTION, ELECTRONIC_PARKING_BAY,
                    ELECTRONIC_STABILITY_CONTROL, FRONT_FOG_LAMPS, HEADLIGHT_TYPE, MASSAGE_SEATS, PARKING_CAMERA, PARKING_SENSORS,
                    PROJECTOR_HEADLAMPS,TRACTION_CONTROL, VENTILATED_SEATS, VEHICLEVARIANT_ID)
values(13,2,true,'22mb',true,false,true,false,'FRONT',true,'FRONT','SENSORS',true,false,true,13);

insert into feature(ID, AIRBAGS, ANTI_LOCK_BRAKE_ABS, DRIVERS_SEAT_MEMORY, ELECTRONIC_BRAKEFORCE_DISTRIBUTION, ELECTRONIC_PARKING_BAY,
                    ELECTRONIC_STABILITY_CONTROL, FRONT_FOG_LAMPS, HEADLIGHT_TYPE, MASSAGE_SEATS, PARKING_CAMERA, PARKING_SENSORS,
                    PROJECTOR_HEADLAMPS,TRACTION_CONTROL, VENTILATED_SEATS, VEHICLEVARIANT_ID)
values(14,2,true,'24mb',true,false,true,false,'REAR',false,'FRONT','SENSORS',true,false,true,14);

insert into feature(ID, AIRBAGS, ANTI_LOCK_BRAKE_ABS, DRIVERS_SEAT_MEMORY, ELECTRONIC_BRAKEFORCE_DISTRIBUTION, ELECTRONIC_PARKING_BAY,
                    ELECTRONIC_STABILITY_CONTROL, FRONT_FOG_LAMPS, HEADLIGHT_TYPE, MASSAGE_SEATS, PARKING_CAMERA, PARKING_SENSORS,
                    PROJECTOR_HEADLAMPS,TRACTION_CONTROL, VENTILATED_SEATS, VEHICLEVARIANT_ID)
values(15,2,true,'22mb',true,false,true,false,'FRONT',true,'FRONT','SENSORS',true,false,true,15);


