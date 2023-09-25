INSERT INTO public.setup_aero
VALUES (1, 4, 56, 3, 77, 8, 5) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_aero
VALUES (2, 4, 50, 4, 78, 8, 5) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_aero
VALUES (3, 4, 50, 4, 78, 8, 7) ON CONFLICT (id) DO NOTHING;



INSERT INTO public.setup_dampers
VALUES (1, 8, 4, 6, 7, 8, 4, 6, 7, 6, 3, 6, 7, 6, 3, 6, 7) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_dampers
VALUES (2, 5, 7, 8, 7, 5, 7, 8, 7, 5, 6, 8, 4, 5, 6, 8, 4) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_dampers
VALUES (3, 5, 7, 8, 7, 5, 7, 8, 7, 5, 6, 8, 4, 5, 6, 8, 4) ON CONFLICT (id) DO NOTHING;



INSERT INTO public.setup_electronics
VALUES (1, 3, 1, 0, 2) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_electronics
VALUES (2, 3, 1, 0, 2) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_electronics
VALUES (3, 3, 1, 0, 2) ON CONFLICT (id) DO NOTHING;



INSERT INTO public.setup_fuel_strategy
VALUES (1, 1, 62, 0, 1, 0) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_fuel_strategy
VALUES (2, 2, 62, 0, 2, 0) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_fuel_strategy
VALUES (3, 2, 62, 0, 2, 0) ON CONFLICT (id) DO NOTHING;



INSERT INTO public.setup_mechanical_grip
VALUES (1, 61, 100, 8, 8, 700, 130000, 8, 700, 130000, 80, 4, 50, 600, 107000, 50, 600, 107000,
        14) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_mechanical_grip
VALUES (2, 61.6, 100, 5, 5, 600, 155000, 5, 600, 155000, 60, 4, 15, 600, 119000, 15, 600, 119000,
        14) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_mechanical_grip
VALUES (3, 61.6, 100, 5, 5, 600, 155000, 5, 600, 155000, 60, 3, 17, 600, 119000, 17, 600, 119000,
        14) ON CONFLICT (id) DO NOTHING;



INSERT INTO public.setup_tyres
VALUES (1, 12.1, 12.1, -3.4, -0.1, 25, -3.4, -0.1, 25, -3.2, 0.05, 25, -3.2, 0.05, 25) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_tyres
VALUES (2, 12.1, 12.1, -4, -0.1, 25, -4, -0.1, 25, 0.1, -3.3, 25, 0.1, -3.3, 25) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_tyres
VALUES (3, 12.1, 12.1, -4, -0.1, 25, -4, -0.1, 25, -3.3, 0.1, 25, -3.3, 0.1, 25) ON CONFLICT (id) DO NOTHING;



INSERT INTO public.validate_aero (id, front_brake_ducts_max, front_brake_ducts_min, front_ride_height_max,
                                  front_ride_height_min, rear_brake_ducts_max, rear_brake_ducts_min,
                                  rear_ride_height_max, rear_ride_height_min, rear_wing_max, rear_wing_min,
                                  splitter_max, splitter_min)
VALUES (1, 6, 0, 88, 50, 6, 0, 90, 67, 10, 1, 11, 1);
INSERT INTO public.validate_aero (id, front_brake_ducts_max, front_brake_ducts_min, front_ride_height_max,
                                  front_ride_height_min, rear_brake_ducts_max, rear_brake_ducts_min,
                                  rear_ride_height_max, rear_ride_height_min, rear_wing_max, rear_wing_min,
                                  splitter_max, splitter_min)
VALUES (2, 6, 0, 80, 50, 6, 0, 105, 64, 12, 1, 3, 0);
INSERT INTO public.validate_aero (id, front_brake_ducts_max, front_brake_ducts_min, front_ride_height_max,
                                  front_ride_height_min, rear_brake_ducts_max, rear_brake_ducts_min,
                                  rear_ride_height_max, rear_ride_height_min, rear_wing_max, rear_wing_min,
                                  splitter_max, splitter_min)
VALUES (3, 6, 0, 85, 53, 6, 0, 90, 55, 12, 0, 0, 0);



INSERT INTO public.validate_dampers (id, front_bump_max, front_bump_min, front_fast_bump_max, front_fast_bump_min,
                                     front_fast_rebound_max, front_fast_rebound_min, front_rebound_max,
                                     front_rebound_min, rear_bump_max, rear_bump_min, rear_fast_bump_max,
                                     rear_fast_bump_min, rear_fast_rebound_max, rear_fast_rebound_min, rear_rebound_max,
                                     rear_rebound_min)
VALUES (1, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0);
INSERT INTO public.validate_dampers (id, front_bump_max, front_bump_min, front_fast_bump_max, front_fast_bump_min,
                                     front_fast_rebound_max, front_fast_rebound_min, front_rebound_max,
                                     front_rebound_min, rear_bump_max, rear_bump_min, rear_fast_bump_max,
                                     rear_fast_bump_min, rear_fast_rebound_max, rear_fast_rebound_min, rear_rebound_max,
                                     rear_rebound_min)
VALUES (2, 40, 0, 39, 0, 39, 0, 40, 0, 40, 0, 39, 0, 39, 0, 40, 0);
INSERT INTO public.validate_dampers (id, front_bump_max, front_bump_min, front_fast_bump_max, front_fast_bump_min,
                                     front_fast_rebound_max, front_fast_rebound_min, front_rebound_max,
                                     front_rebound_min, rear_bump_max, rear_bump_min, rear_fast_bump_max,
                                     rear_fast_bump_min, rear_fast_rebound_max, rear_fast_rebound_min, rear_rebound_max,
                                     rear_rebound_min)
VALUES (3, 17, 0, 12, 0, 12, 0, 17, 0, 17, 0, 12, 0, 12, 0, 17, 0);



INSERT INTO public.validate_electronics (id, abs_max, abs_min, ecu_map_max, ecu_map_min, telemetry_laps_max,
                                         telemetry_laps_min, traction_control_max, traction_control_min)
VALUES (1, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO public.validate_electronics (id, abs_max, abs_min, ecu_map_max, ecu_map_min, telemetry_laps_max,
                                         telemetry_laps_min, traction_control_max, traction_control_min)
VALUES (2, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO public.validate_electronics (id, abs_max, abs_min, ecu_map_max, ecu_map_min, telemetry_laps_max,
                                         telemetry_laps_min, traction_control_max, traction_control_min)
VALUES (3, 0, 0, 0, 0, 0, 0, 0, 0);

ta
for
Name: validate_fuel_strategy; Type
: TABLE DATA;
Schema: public; Owner
: postgres
--

INSERT INTO public.validate_fuel_strategy (id, brakes_max, brakes_min, fuel_max, fuel_min, fuel_per_lap, tyre_type) VALUES (1, 4, 1, 0, 2, 0, 0);
INSERT INTO public.validate_fuel_strategy (id, brakes_max, brakes_min, fuel_max, fuel_min, fuel_per_lap, tyre_type)
VALUES (2, 4, 1, 0, 2, 0, 0);
INSERT INTO public.validate_fuel_strategy (id, brakes_max, brakes_min, fuel_max, fuel_min, fuel_per_lap, tyre_type)
VALUES (3, 4, 1, 0, 2, 0, 0);



INSERT INTO public.validate_mechanical_grip (id, brake_bias_max, brake_bias_min, brake_power, front_anti_roll_bar_max,
                                             front_anti_roll_bar_min, front_bump_stop_range_max,
                                             front_bump_stop_range_min, front_bump_stop_rate_max,
                                             front_bump_stop_rate_min, front_wheel_rate_max, front_wheel_rate_min,
                                             preload_differential_max, preload_differential_min, rear_anti_roll_bar_max,
                                             rear_anti_roll_bar_min, rear_bump_stop_range_max, rear_bump_stop_range_min,
                                             rear_bump_stop_rate_max, rear_bump_stop_rate_min, rear_wheel_rate_max,
                                             rear_wheel_rate_min, steer_ratio_max, steer_ratio_min)
VALUES (1, 0, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO public.validate_mechanical_grip (id, brake_bias_max, brake_bias_min, brake_power, front_anti_roll_bar_max,
                                             front_anti_roll_bar_min, front_bump_stop_range_max,
                                             front_bump_stop_range_min, front_bump_stop_rate_max,
                                             front_bump_stop_rate_min, front_wheel_rate_max, front_wheel_rate_min,
                                             preload_differential_max, preload_differential_min, rear_anti_roll_bar_max,
                                             rear_anti_roll_bar_min, rear_bump_stop_range_max, rear_bump_stop_range_min,
                                             rear_bump_stop_rate_max, rear_bump_stop_rate_min, rear_wheel_rate_max,
                                             rear_wheel_rate_min, steer_ratio_max, steer_ratio_min)
VALUES (2, 0, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO public.validate_mechanical_grip (id, brake_bias_max, brake_bias_min, brake_power, front_anti_roll_bar_max,
                                             front_anti_roll_bar_min, front_bump_stop_range_max,
                                             front_bump_stop_range_min, front_bump_stop_rate_max,
                                             front_bump_stop_rate_min, front_wheel_rate_max, front_wheel_rate_min,
                                             preload_differential_max, preload_differential_min, rear_anti_roll_bar_max,
                                             rear_anti_roll_bar_min, rear_bump_stop_range_max, rear_bump_stop_range_min,
                                             rear_bump_stop_rate_max, rear_bump_stop_rate_min, rear_wheel_rate_max,
                                             rear_wheel_rate_min, steer_ratio_max, steer_ratio_min)
VALUES (3, 0, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);



INSERT INTO public.validate_setup (id, car_type, validate_aero_id, validate_dampers_id, validate_electronics_id,
                                   validate_fuel_strategy_id, validate_mechanical_grip_id, validate_tyres_id)
VALUES (2, 0, 1, 1, 1, 1, 1, 1);
INSERT INTO public.validate_setup (id, car_type, validate_aero_id, validate_dampers_id, validate_electronics_id,
                                   validate_fuel_strategy_id, validate_mechanical_grip_id, validate_tyres_id)
VALUES (3, 1, 2, 2, 2, 2, 2, 2);
INSERT INTO public.validate_setup (id, car_type, validate_aero_id, validate_dampers_id, validate_electronics_id,
                                   validate_fuel_strategy_id, validate_mechanical_grip_id, validate_tyres_id)
VALUES (4, 2, 3, 3, 3, 3, 3, 3);



INSERT INTO public.validate_tyres (id, caster_max, caster_min, front_camber_max, front_camber_min, front_toe_max,
                                   front_toe_min, rear_camber_max, rear_camber_min, rear_toe_max, rear_toe_min,
                                   tyre_pressure_max, tyre_pressure_min)
VALUES (1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 25);
INSERT INTO public.validate_tyres (id, caster_max, caster_min, front_camber_max, front_camber_min, front_toe_max,
                                   front_toe_min, rear_camber_max, rear_camber_min, rear_toe_max, rear_toe_min,
                                   tyre_pressure_max, tyre_pressure_min)
VALUES (2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 25);
INSERT INTO public.validate_tyres (id, caster_max, caster_min, front_camber_max, front_camber_min, front_toe_max,
                                   front_toe_min, rear_camber_max, rear_camber_min, rear_toe_max, rear_toe_min,
                                   tyre_pressure_max, tyre_pressure_min)
VALUES (3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 25);



INSERT INTO public.users
VALUES (1, 'admin@admin.com', '$2a$10$h.ZI50pDChoNxLJ.xCYVSem4da8F08XcU6ID3hsVwS2axhV12SQOy', 'ADMIN',
        'admin') ON CONFLICT (id) DO NOTHING;



INSERT INTO public.setup
VALUES (1, 0, 'default_mercedes_imola', 1, 0, 1, 1, 1, 1, 1, 1, 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup
VALUES (2, 0, 'default_mercedes_nurburgring', 1, 1, 2, 2, 2, 2, 2, 2, 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup
VALUES (3, 0, 'default_mercedes_barcelona', 1, 2, 3, 3, 3, 3, 3, 3, 1) ON CONFLICT (id) DO NOTHING;
