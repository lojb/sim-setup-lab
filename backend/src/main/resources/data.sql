INSERT INTO public.setup
VALUES (1, 0, 'default_mercedes_imola', 1, 0, 1, 1, 1, 1, 1, 1, 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup
VALUES (2, 0, 'default_mercedes_nurburgring', 1, 1, 2, 2, 2, 2, 2, 2, 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup
VALUES (3, 0, 'default_mercedes_barcelona', 1, 2, 3, 3, 3, 3, 3, 3, 1) ON CONFLICT (id) DO NOTHING;


--
-- TOC entry 3512 (class 0 OID 33253)
-- Dependencies: 219
-- Data for Name: setup_aero; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.setup_aero
VALUES (1, 4, 56, 3, 77, 8, 5) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_aero
VALUES (2, 4, 50, 4, 78, 8, 5) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_aero
VALUES (3, 4, 50, 4, 78, 8, 7) ON CONFLICT (id) DO NOTHING;


--
-- TOC entry 3514 (class 0 OID 33260)
-- Dependencies: 221
-- Data for Name: setup_dampers; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.setup_dampers
VALUES (1, 8, 4, 6, 7, 8, 4, 6, 7, 6, 3, 6, 7, 6, 3, 6, 7) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_dampers
VALUES (2, 5, 7, 8, 7, 5, 7, 8, 7, 5, 6, 8, 4, 5, 6, 8, 4) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_dampers
VALUES (3, 5, 7, 8, 7, 5, 7, 8, 7, 5, 6, 8, 4, 5, 6, 8, 4) ON CONFLICT (id) DO NOTHING;


--
-- TOC entry 3516 (class 0 OID 33267)
-- Dependencies: 223
-- Data for Name: setup_electronics; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.setup_electronics
VALUES (1, 3, 1, 0, 2) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_electronics
VALUES (2, 3, 1, 0, 2) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_electronics
VALUES (3, 3, 1, 0, 2) ON CONFLICT (id) DO NOTHING;


--
-- TOC entry 3518 (class 0 OID 33274)
-- Dependencies: 225
-- Data for Name: setup_fuel_strategy; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.setup_fuel_strategy
VALUES (1, 1, 62, 0, 1, 0) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_fuel_strategy
VALUES (2, 2, 62, 0, 2, 0) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_fuel_strategy
VALUES (3, 2, 62, 0, 2, 0) ON CONFLICT (id) DO NOTHING;


--
-- TOC entry 3520 (class 0 OID 33282)
-- Dependencies: 227
-- Data for Name: setup_mechanical_grip; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.setup_mechanical_grip
VALUES (1, 61, 100, 8, 8, 700, 130000, 8, 700, 130000, 80, 4, 50, 600, 107000, 50, 600, 107000,
        14) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_mechanical_grip
VALUES (2, 61.6, 100, 5, 5, 600, 155000, 5, 600, 155000, 60, 4, 15, 600, 119000, 15, 600, 119000,
        14) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_mechanical_grip
VALUES (3, 61.6, 100, 5, 5, 600, 155000, 5, 600, 155000, 60, 3, 17, 600, 119000, 17, 600, 119000,
        14) ON CONFLICT (id) DO NOTHING;


--
-- TOC entry 3522 (class 0 OID 33289)
-- Dependencies: 229
-- Data for Name: setup_tyres; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.setup_tyres
VALUES (1, 12.1, 12.1, -3.4, -0.1, 25, -3.4, -0.1, 25, -3.2, 0.05, 25, -3.2, 0.05, 25) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_tyres
VALUES (2, 12.1, 12.1, -4, -0.1, 25, -4, -0.1, 25, 0.1, -3.3, 25, 0.1, -3.3, 25) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.setup_tyres
VALUES (3, 12.1, 12.1, -4, -0.1, 25, -4, -0.1, 25, -3.3, 0.1, 25, -3.3, 0.1, 25) ON CONFLICT (id) DO NOTHING;


--
-- TOC entry 3524 (class 0 OID 33296)
-- Dependencies: 231
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users
VALUES (1, 'admin@admin.com', '$2a$10$h.ZI50pDChoNxLJ.xCYVSem4da8F08XcU6ID3hsVwS2axhV12SQOy', 'ADMIN', 'admin') ON CONFLICT (id) DO NOTHING;
