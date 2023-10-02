INSERT INTO public.setup_aero
VALUES (1, 4, 56, 3, 77, 8, 5)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_aero
VALUES (2, 4, 50, 4, 78, 8, 5)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_aero
VALUES (3, 4, 50, 4, 78, 8, 7)
ON CONFLICT (id) DO NOTHING;



INSERT INTO public.setup_dampers
VALUES (1, 8, 4, 6, 7, 8, 4, 6, 7, 6, 3, 6, 7, 6, 3, 6, 7)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_dampers
VALUES (2, 5, 7, 8, 7, 5, 7, 8, 7, 5, 6, 8, 4, 5, 6, 8, 4)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_dampers
VALUES (3, 5, 7, 8, 7, 5, 7, 8, 7, 5, 6, 8, 4, 5, 6, 8, 4)
ON CONFLICT (id) DO NOTHING;



INSERT INTO public.setup_electronics
VALUES (1, 3, 1, 0, 2)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_electronics
VALUES (2, 3, 1, 0, 2)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_electronics
VALUES (3, 3, 1, 0, 2)
ON CONFLICT (id) DO NOTHING;



INSERT INTO public.setup_fuel_strategy
VALUES (1, 1, 62, 0, 1, 0)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_fuel_strategy
VALUES (2, 2, 62, 0, 2, 0)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_fuel_strategy
VALUES (3, 2, 62, 0, 2, 0)
ON CONFLICT (id) DO NOTHING;



INSERT INTO public.setup_mechanical_grip
VALUES (1, 61, 100, 8, 8, 700, 130000, 8, 700, 130000, 80, 4, 50, 600, 107000, 50, 600, 107000,
        14)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_mechanical_grip
VALUES (2, 61.6, 100, 5, 5, 600, 155000, 5, 600, 155000, 60, 4, 15, 600, 119000, 15, 600, 119000,
        14)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_mechanical_grip
VALUES (3, 61.6, 100, 5, 5, 600, 155000, 5, 600, 155000, 60, 3, 17, 600, 119000, 17, 600, 119000,
        14)
ON CONFLICT (id) DO NOTHING;



INSERT INTO public.setup_tyres
VALUES (1, 12.1, 12.1, -3.4, -0.1, 25, -3.4, -0.1, 25, -3.2, 0.05, 25, -3.2, 0.05, 25)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_tyres
VALUES (2, 12.1, 12.1, -4, -0.1, 25, -4, -0.1, 25, 0.1, -3.3, 25, 0.1, -3.3, 25)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_tyres
VALUES (3, 12.1, 12.1, -4, -0.1, 25, -4, -0.1, 25, -3.3, 0.1, 25, -3.3, 0.1, 25)
ON CONFLICT (id) DO NOTHING;



INSERT INTO public.validate_aero
VALUES (1, 6, 0, 88, 50, 6, 0, 90, 67, 10, 1, 11, 1)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.validate_aero
VALUES (2, 6, 0, 80, 50, 6, 0, 105, 64, 12, 1, 3, 0)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.validate_aero
VALUES (3, 6, 0, 85, 53, 6, 0, 90, 55, 12, 0, 0, 0)
ON CONFLICT (id) DO NOTHING;



INSERT INTO public.validate_dampers
VALUES (1, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.validate_dampers
VALUES (2, 40, 0, 39, 0, 39, 0, 40, 0, 40, 0, 39, 0, 39, 0, 40, 0)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.validate_dampers
VALUES (3, 17, 0, 12, 0, 12, 0, 17, 0, 17, 0, 12, 0, 12, 0, 17, 0)
ON CONFLICT (id) DO NOTHING;



INSERT INTO public.validate_electronics
VALUES (1, 10, 0, 3, 1, 99, 0, 11, 0)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.validate_electronics
VALUES (2, 12, 0, 13, 1, 99, 0, 12, 0)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.validate_electronics
VALUES (3, 11, 0, 10, 1, 99, 0, 11, 0)
ON CONFLICT (id) DO NOTHING;



INSERT INTO public.validate_fuel_strategy
VALUES (1, 4, 1, 108, 2, 0, 0)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.validate_fuel_strategy
VALUES (2, 4, 1, 120, 2, 0, 0)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.validate_fuel_strategy
VALUES (3, 4, 1, 120, 2, 0, 0)
ON CONFLICT (id) DO NOTHING;



INSERT INTO public.validate_mechanical_grip
VALUES (1, 71, 50, 100, 10, 0, 46, 0, 2500, 300, 202000, 130000, 300, 20, 13, 0, 76, 0, 2500, 300, 131000, 71000, 17,
        11)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.validate_mechanical_grip
VALUES (2, 68, 47, 100, 11, 0, 40, 0, 2500, 300, 230000, 118000, 160, 20, 14, 0, 30, 0, 2500, 300, 209000, 83000, 17,
        11)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.validate_mechanical_grip
VALUES (3, 64, 43, 100, 6, 0, 49, 0, 2500, 300, 173500, 100500, 300, 20, 6, 0, 50, 0, 2500, 300, 237000, 137000, 17, 11)
ON CONFLICT (id) DO NOTHING;



INSERT INTO public.validate_tyres
VALUES (1, 14.1, 6, -1.5, -4, 0.4, -0.4, -1, -3.5, 0.4, -0.4, 0, 0)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.validate_tyres
VALUES (2, 16.3, 5.3, -1.5, -4, 0.48, -0.48, -1, -3.5, 0.4, -0.1, 35, 20.3)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.validate_tyres
VALUES (3, 12.4, 6.5, -1.5, -4, 0.4, -0.4, -1, -3.5, 0.4, -0.4, 35, 20.3)
ON CONFLICT (id) DO NOTHING;



INSERT INTO public.users
VALUES (1, 'admin@admin.com', '$2a$10$h.ZI50pDChoNxLJ.xCYVSem4da8F08XcU6ID3hsVwS2axhV12SQOy', 'ADMIN',
        'admin')
ON CONFLICT (id) DO NOTHING;



INSERT INTO public.setup
VALUES (1, 0, 'default_mercedes_imola', 1, 0, 1, 1, 1, 1, 1, 1, 1)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup
VALUES (2, 0, 'default_mercedes_nurburgring', 1, 1, 2, 2, 2, 2, 2, 2, 1)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup
VALUES (3, 0, 'default_mercedes_barcelona', 1, 2, 3, 3, 3, 3, 3, 3, 1)
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.validate_setup
VALUES (1, 0, 1, 1, 1, 1, 1, 1)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.validate_setup
VALUES (2, 1, 2, 2, 2, 2, 2, 2)
ON CONFLICT (id) DO NOTHING;
INSERT INTO public.validate_setup
VALUES (3, 2, 3, 3, 3, 3, 3, 3)
ON CONFLICT (id) DO NOTHING;
