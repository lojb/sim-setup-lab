--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-09-18 11:30:24

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 33243)
-- Name: setup; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.setup (
                              id bigint NOT NULL,
                              car_type smallint,
                              name character varying(255),
                              setup_type smallint,
                              track smallint,
                              aero_id bigint,
                              dampers_id bigint,
                              electronics_id bigint,
                              fuel_strategy_id bigint,
                              mechanical_grip_id bigint,
                              tyres_id bigint,
                              user_id bigint,
                              CONSTRAINT setup_car_type_check CHECK (((car_type >= 0) AND (car_type <= 2))),
                              CONSTRAINT setup_setup_type_check CHECK (((setup_type >= 0) AND (setup_type <= 1))),
                              CONSTRAINT setup_track_check CHECK (((track >= 0) AND (track <= 2)))
);


ALTER TABLE public.setup OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 33253)
-- Name: setup_aero; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.setup_aero (
                                   id bigint NOT NULL,
                                   front_brake_ducts integer NOT NULL,
                                   front_ride_height integer NOT NULL,
                                   rear_brake_ducts integer NOT NULL,
                                   rear_ride_height integer NOT NULL,
                                   rear_wing integer NOT NULL,
                                   splitter integer NOT NULL
);


ALTER TABLE public.setup_aero OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 33252)
-- Name: setup_aero_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.setup_aero_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.setup_aero_id_seq OWNER TO postgres;

--
-- TOC entry 3544 (class 0 OID 0)
-- Dependencies: 218
-- Name: setup_aero_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.setup_aero_id_seq OWNED BY public.setup_aero.id;


--
-- TOC entry 221 (class 1259 OID 33260)
-- Name: setup_dampers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.setup_dampers (
                                      id bigint NOT NULL,
                                      front_left_bump integer NOT NULL,
                                      front_left_fast_bump integer NOT NULL,
                                      front_left_fast_rebound integer NOT NULL,
                                      front_left_rebound integer NOT NULL,
                                      front_right_bump integer NOT NULL,
                                      front_right_fast_bump integer NOT NULL,
                                      front_right_fast_rebound integer NOT NULL,
                                      front_right_rebound integer NOT NULL,
                                      rear_left_bump integer NOT NULL,
                                      rear_left_fast_bump integer NOT NULL,
                                      rear_left_fast_rebound integer NOT NULL,
                                      rear_left_rebound integer NOT NULL,
                                      rear_right_bump integer NOT NULL,
                                      rear_right_fast_bump integer NOT NULL,
                                      rear_right_fast_rebound integer NOT NULL,
                                      rear_right_rebound integer NOT NULL
);


ALTER TABLE public.setup_dampers OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 33259)
-- Name: setup_dampers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.setup_dampers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.setup_dampers_id_seq OWNER TO postgres;

--
-- TOC entry 3545 (class 0 OID 0)
-- Dependencies: 220
-- Name: setup_dampers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.setup_dampers_id_seq OWNED BY public.setup_dampers.id;


--
-- TOC entry 223 (class 1259 OID 33267)
-- Name: setup_electronics; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.setup_electronics (
                                          id bigint NOT NULL,
                                          abs integer NOT NULL,
                                          ecu_map integer NOT NULL,
                                          telemetry_laps integer NOT NULL,
                                          traction_control integer NOT NULL
);


ALTER TABLE public.setup_electronics OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 33266)
-- Name: setup_electronics_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.setup_electronics_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.setup_electronics_id_seq OWNER TO postgres;

--
-- TOC entry 3546 (class 0 OID 0)
-- Dependencies: 222
-- Name: setup_electronics_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.setup_electronics_id_seq OWNED BY public.setup_electronics.id;


--
-- TOC entry 225 (class 1259 OID 33274)
-- Name: setup_fuel_strategy; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.setup_fuel_strategy (
                                            id bigint NOT NULL,
                                            front_brakes integer NOT NULL,
                                            fuel integer NOT NULL,
                                            fuel_per_lap double precision NOT NULL,
                                            rear_brakes integer NOT NULL,
                                            tyre_type smallint,
                                            CONSTRAINT setup_fuel_strategy_tyre_type_check CHECK (((tyre_type >= 0) AND (tyre_type <= 1)))
);


ALTER TABLE public.setup_fuel_strategy OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 33273)
-- Name: setup_fuel_strategy_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.setup_fuel_strategy_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.setup_fuel_strategy_id_seq OWNER TO postgres;

--
-- TOC entry 3547 (class 0 OID 0)
-- Dependencies: 224
-- Name: setup_fuel_strategy_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.setup_fuel_strategy_id_seq OWNED BY public.setup_fuel_strategy.id;


--
-- TOC entry 216 (class 1259 OID 33242)
-- Name: setup_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.setup_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.setup_id_seq OWNER TO postgres;

--
-- TOC entry 3548 (class 0 OID 0)
-- Dependencies: 216
-- Name: setup_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.setup_id_seq OWNED BY public.setup.id;


--
-- TOC entry 227 (class 1259 OID 33282)
-- Name: setup_mechanical_grip; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.setup_mechanical_grip (
                                              id bigint NOT NULL,
                                              brake_bias real NOT NULL,
                                              brake_power integer NOT NULL,
                                              front_anti_roll_bar integer NOT NULL,
                                              front_left_bumpstop_range integer NOT NULL,
                                              front_left_bumpstop_rate integer NOT NULL,
                                              front_left_wheel_rate integer NOT NULL,
                                              front_right_bumpstop_range integer NOT NULL,
                                              front_right_bumpstop_rate integer NOT NULL,
                                              front_right_wheel_rate integer NOT NULL,
                                              preload_differential integer NOT NULL,
                                              rear_anti_roll_bar integer NOT NULL,
                                              rear_left_bumpstop_range integer NOT NULL,
                                              rear_left_bumpstop_rate integer NOT NULL,
                                              rear_left_wheel_rate integer NOT NULL,
                                              rear_right_bumpstop_range integer NOT NULL,
                                              rear_right_bumpstop_rate integer NOT NULL,
                                              rear_right_wheel_rate integer NOT NULL,
                                              steer_ratio integer NOT NULL
);


ALTER TABLE public.setup_mechanical_grip OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 33281)
-- Name: setup_mechanical_grip_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.setup_mechanical_grip_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.setup_mechanical_grip_id_seq OWNER TO postgres;

--
-- TOC entry 3549 (class 0 OID 0)
-- Dependencies: 226
-- Name: setup_mechanical_grip_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.setup_mechanical_grip_id_seq OWNED BY public.setup_mechanical_grip.id;


--
-- TOC entry 229 (class 1259 OID 33289)
-- Name: setup_tyres; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.setup_tyres (
                                    id bigint NOT NULL,
                                    caster_left real NOT NULL,
                                    caster_right real NOT NULL,
                                    front_left_camber real NOT NULL,
                                    front_left_toe real NOT NULL,
                                    front_left_tyre_pressure real NOT NULL,
                                    front_right_camber real NOT NULL,
                                    front_right_toe real NOT NULL,
                                    front_right_tyre_pressure real NOT NULL,
                                    rear_left_camber real NOT NULL,
                                    rear_left_toe real NOT NULL,
                                    rear_left_tyre_pressure real NOT NULL,
                                    rear_right_camber real NOT NULL,
                                    rear_right_toe real NOT NULL,
                                    rear_right_tyre_pressure real NOT NULL
);


ALTER TABLE public.setup_tyres OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 33288)
-- Name: setup_tyres_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.setup_tyres_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.setup_tyres_id_seq OWNER TO postgres;

--
-- TOC entry 3550 (class 0 OID 0)
-- Dependencies: 228
-- Name: setup_tyres_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.setup_tyres_id_seq OWNED BY public.setup_tyres.id;


--
-- TOC entry 231 (class 1259 OID 33296)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
                              id bigint NOT NULL,
                              email character varying(255),
                              password character varying(255),
                              role character varying(255),
                              username character varying(255),
                              CONSTRAINT users_role_check CHECK (((role)::text = ANY ((ARRAY['USER'::character varying, 'ADMIN'::character varying])::text[])))
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 33295)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 3551 (class 0 OID 0)
-- Dependencies: 230
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 233 (class 1259 OID 33306)
-- Name: validate_aero; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.validate_aero (
                                      id bigint NOT NULL,
                                      car smallint,
                                      front_brake_ducts_max integer NOT NULL,
                                      front_brake_ducts_min integer NOT NULL,
                                      front_ride_height_max integer NOT NULL,
                                      front_ride_height_min integer NOT NULL,
                                      rear_brake_ducts_max integer NOT NULL,
                                      rear_brake_ducts_min integer NOT NULL,
                                      rear_ride_height_max integer NOT NULL,
                                      rear_ride_height_min integer NOT NULL,
                                      rear_wing_max integer NOT NULL,
                                      rear_wing_min integer NOT NULL,
                                      splitter_max integer NOT NULL,
                                      splitter_min integer NOT NULL,
                                      CONSTRAINT validate_aero_car_check CHECK (((car >= 0) AND (car <= 2)))
);


ALTER TABLE public.validate_aero OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 33305)
-- Name: validate_aero_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.validate_aero_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.validate_aero_id_seq OWNER TO postgres;

--
-- TOC entry 3552 (class 0 OID 0)
-- Dependencies: 232
-- Name: validate_aero_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.validate_aero_id_seq OWNED BY public.validate_aero.id;


--
-- TOC entry 235 (class 1259 OID 33314)
-- Name: validate_dampers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.validate_dampers (
                                         id bigint NOT NULL,
                                         car smallint,
                                         front_bump_max integer NOT NULL,
                                         front_bump_min integer NOT NULL,
                                         front_fast_bump_max integer NOT NULL,
                                         front_fast_bump_min integer NOT NULL,
                                         front_fast_rebound_max integer NOT NULL,
                                         front_fast_rebound_min integer NOT NULL,
                                         front_rebound_max integer NOT NULL,
                                         front_rebound_min integer NOT NULL,
                                         rear_bump_max integer NOT NULL,
                                         rear_bump_min integer NOT NULL,
                                         rear_fast_bump_max integer NOT NULL,
                                         rear_fast_bump_min integer NOT NULL,
                                         rear_fast_rebound_max integer NOT NULL,
                                         rear_fast_rebound_min integer NOT NULL,
                                         rear_rebound_max integer NOT NULL,
                                         rear_rebound_min integer NOT NULL,
                                         CONSTRAINT validate_dampers_car_check CHECK (((car >= 0) AND (car <= 2)))
);


ALTER TABLE public.validate_dampers OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 33313)
-- Name: validate_dampers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.validate_dampers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.validate_dampers_id_seq OWNER TO postgres;

--
-- TOC entry 3553 (class 0 OID 0)
-- Dependencies: 234
-- Name: validate_dampers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.validate_dampers_id_seq OWNED BY public.validate_dampers.id;


--
-- TOC entry 237 (class 1259 OID 33322)
-- Name: validate_electronics; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.validate_electronics (
                                             id bigint NOT NULL,
                                             abs_max integer NOT NULL,
                                             abs_min integer NOT NULL,
                                             car smallint,
                                             ecu_map_max integer NOT NULL,
                                             ecu_map_min integer NOT NULL,
                                             telemetry_laps_max integer NOT NULL,
                                             telemetry_laps_min integer NOT NULL,
                                             traction_control_max integer NOT NULL,
                                             traction_control_min integer NOT NULL,
                                             CONSTRAINT validate_electronics_car_check CHECK (((car >= 0) AND (car <= 2)))
);


ALTER TABLE public.validate_electronics OWNER TO postgres;

--
-- TOC entry 236 (class 1259 OID 33321)
-- Name: validate_electronics_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.validate_electronics_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.validate_electronics_id_seq OWNER TO postgres;

--
-- TOC entry 3554 (class 0 OID 0)
-- Dependencies: 236
-- Name: validate_electronics_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.validate_electronics_id_seq OWNED BY public.validate_electronics.id;


--
-- TOC entry 239 (class 1259 OID 33330)
-- Name: validate_fuel_strategy; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.validate_fuel_strategy (
                                               id bigint NOT NULL,
                                               brakes_max integer NOT NULL,
                                               brakes_min integer NOT NULL,
                                               car smallint,
                                               fuel_max integer NOT NULL,
                                               fuel_min integer NOT NULL,
                                               fuel_per_lap double precision NOT NULL,
                                               tyre_type_min smallint,
                                               CONSTRAINT validate_fuel_strategy_car_check CHECK (((car >= 0) AND (car <= 2))),
                                               CONSTRAINT validate_fuel_strategy_tyre_type_min_check CHECK (((tyre_type_min >= 0) AND (tyre_type_min <= 1)))
);


ALTER TABLE public.validate_fuel_strategy OWNER TO postgres;

--
-- TOC entry 238 (class 1259 OID 33329)
-- Name: validate_fuel_strategy_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.validate_fuel_strategy_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.validate_fuel_strategy_id_seq OWNER TO postgres;

--
-- TOC entry 3555 (class 0 OID 0)
-- Dependencies: 238
-- Name: validate_fuel_strategy_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.validate_fuel_strategy_id_seq OWNED BY public.validate_fuel_strategy.id;


--
-- TOC entry 241 (class 1259 OID 33339)
-- Name: validate_mechanical_grip; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.validate_mechanical_grip (
                                                 id bigint NOT NULL,
                                                 brake_bias_max real NOT NULL,
                                                 brake_bias_min real NOT NULL,
                                                 brake_power integer NOT NULL,
                                                 car smallint,
                                                 front_anti_roll_bar_max integer NOT NULL,
                                                 front_anti_roll_bar_min integer NOT NULL,
                                                 front_bump_stop_range_max integer NOT NULL,
                                                 front_bump_stop_range_min integer NOT NULL,
                                                 front_bump_stop_rate_max integer NOT NULL,
                                                 front_bump_stop_rate_min integer NOT NULL,
                                                 front_wheel_rate_max integer NOT NULL,
                                                 front_wheel_rate_min integer NOT NULL,
                                                 preload_differential_max integer NOT NULL,
                                                 preload_differential_min integer NOT NULL,
                                                 rear_anti_roll_bar_max integer NOT NULL,
                                                 rear_anti_roll_bar_min integer NOT NULL,
                                                 rear_bump_stop_range_max integer NOT NULL,
                                                 rear_bump_stop_range_min integer NOT NULL,
                                                 rear_bump_stop_rate_max integer NOT NULL,
                                                 rear_bump_stop_rate_min integer NOT NULL,
                                                 rear_wheel_rate_max integer NOT NULL,
                                                 rear_wheel_rate_min integer NOT NULL,
                                                 steer_ratio_max integer NOT NULL,
                                                 steer_ratio_min integer NOT NULL,
                                                 CONSTRAINT validate_mechanical_grip_car_check CHECK (((car >= 0) AND (car <= 2)))
);


ALTER TABLE public.validate_mechanical_grip OWNER TO postgres;

--
-- TOC entry 240 (class 1259 OID 33338)
-- Name: validate_mechanical_grip_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.validate_mechanical_grip_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.validate_mechanical_grip_id_seq OWNER TO postgres;

--
-- TOC entry 3556 (class 0 OID 0)
-- Dependencies: 240
-- Name: validate_mechanical_grip_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.validate_mechanical_grip_id_seq OWNED BY public.validate_mechanical_grip.id;


--
-- TOC entry 243 (class 1259 OID 33347)
-- Name: validate_setup; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.validate_setup (
                                       id bigint NOT NULL,
                                       car_type smallint,
                                       validate_aero_id bigint,
                                       validate_dampers_id bigint,
                                       validate_electronics_id bigint,
                                       validate_fuel_strategy_id bigint,
                                       validate_mechanical_grip_id bigint,
                                       validate_tyres_id bigint,
                                       CONSTRAINT validate_setup_car_type_check CHECK (((car_type >= 0) AND (car_type <= 2)))
);


ALTER TABLE public.validate_setup OWNER TO postgres;

--
-- TOC entry 242 (class 1259 OID 33346)
-- Name: validate_setup_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.validate_setup_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.validate_setup_id_seq OWNER TO postgres;

--
-- TOC entry 3557 (class 0 OID 0)
-- Dependencies: 242
-- Name: validate_setup_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.validate_setup_id_seq OWNED BY public.validate_setup.id;


--
-- TOC entry 245 (class 1259 OID 33355)
-- Name: validate_tyres; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.validate_tyres (
                                       id bigint NOT NULL,
                                       car smallint,
                                       caster_max real NOT NULL,
                                       caster_min real NOT NULL,
                                       front_camber_max real NOT NULL,
                                       front_camber_min real NOT NULL,
                                       front_toe_max real NOT NULL,
                                       front_toe_min real NOT NULL,
                                       rear_camber_max real NOT NULL,
                                       rear_camber_min real NOT NULL,
                                       rear_toe_max real NOT NULL,
                                       rear_toe_min real NOT NULL,
                                       tyre_pressure_max real NOT NULL,
                                       tyre_pressure_min real NOT NULL,
                                       CONSTRAINT validate_tyres_car_check CHECK (((car >= 0) AND (car <= 2)))
);


ALTER TABLE public.validate_tyres OWNER TO postgres;

--
-- TOC entry 244 (class 1259 OID 33354)
-- Name: validate_tyres_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.validate_tyres_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.validate_tyres_id_seq OWNER TO postgres;

--
-- TOC entry 3558 (class 0 OID 0)
-- Dependencies: 244
-- Name: validate_tyres_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.validate_tyres_id_seq OWNED BY public.validate_tyres.id;


--
-- TOC entry 215 (class 1259 OID 25318)
-- Name: validator; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.validator (
                                  id bigint NOT NULL,
                                  car_type smallint,
                                  validate_aero_id bigint,
                                  validate_dampers_id bigint,
                                  validate_electronics_id bigint,
                                  validate_fuel_strategy_id bigint,
                                  validate_mechanical_grip_id bigint,
                                  validate_tyres_id bigint,
                                  CONSTRAINT validator_car_type_check CHECK (((car_type >= 0) AND (car_type <= 2)))
);


ALTER TABLE public.validator OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 25317)
-- Name: validator_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.validator_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.validator_id_seq OWNER TO postgres;

--
-- TOC entry 3559 (class 0 OID 0)
-- Dependencies: 214
-- Name: validator_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.validator_id_seq OWNED BY public.validator.id;


--
-- TOC entry 3249 (class 2604 OID 33246)
-- Name: setup id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup ALTER COLUMN id SET DEFAULT nextval('public.setup_id_seq'::regclass);


--
-- TOC entry 3250 (class 2604 OID 33256)
-- Name: setup_aero id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_aero ALTER COLUMN id SET DEFAULT nextval('public.setup_aero_id_seq'::regclass);


--
-- TOC entry 3251 (class 2604 OID 33263)
-- Name: setup_dampers id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_dampers ALTER COLUMN id SET DEFAULT nextval('public.setup_dampers_id_seq'::regclass);


--
-- TOC entry 3252 (class 2604 OID 33270)
-- Name: setup_electronics id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_electronics ALTER COLUMN id SET DEFAULT nextval('public.setup_electronics_id_seq'::regclass);


--
-- TOC entry 3253 (class 2604 OID 33277)
-- Name: setup_fuel_strategy id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_fuel_strategy ALTER COLUMN id SET DEFAULT nextval('public.setup_fuel_strategy_id_seq'::regclass);


--
-- TOC entry 3254 (class 2604 OID 33285)
-- Name: setup_mechanical_grip id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_mechanical_grip ALTER COLUMN id SET DEFAULT nextval('public.setup_mechanical_grip_id_seq'::regclass);


--
-- TOC entry 3255 (class 2604 OID 33292)
-- Name: setup_tyres id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_tyres ALTER COLUMN id SET DEFAULT nextval('public.setup_tyres_id_seq'::regclass);


--
-- TOC entry 3256 (class 2604 OID 33299)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 3257 (class 2604 OID 33309)
-- Name: validate_aero id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_aero ALTER COLUMN id SET DEFAULT nextval('public.validate_aero_id_seq'::regclass);


--
-- TOC entry 3258 (class 2604 OID 33317)
-- Name: validate_dampers id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_dampers ALTER COLUMN id SET DEFAULT nextval('public.validate_dampers_id_seq'::regclass);


--
-- TOC entry 3259 (class 2604 OID 33325)
-- Name: validate_electronics id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_electronics ALTER COLUMN id SET DEFAULT nextval('public.validate_electronics_id_seq'::regclass);


--
-- TOC entry 3260 (class 2604 OID 33333)
-- Name: validate_fuel_strategy id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_fuel_strategy ALTER COLUMN id SET DEFAULT nextval('public.validate_fuel_strategy_id_seq'::regclass);


--
-- TOC entry 3261 (class 2604 OID 33342)
-- Name: validate_mechanical_grip id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_mechanical_grip ALTER COLUMN id SET DEFAULT nextval('public.validate_mechanical_grip_id_seq'::regclass);


--
-- TOC entry 3262 (class 2604 OID 33350)
-- Name: validate_setup id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup ALTER COLUMN id SET DEFAULT nextval('public.validate_setup_id_seq'::regclass);


--
-- TOC entry 3263 (class 2604 OID 33358)
-- Name: validate_tyres id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_tyres ALTER COLUMN id SET DEFAULT nextval('public.validate_tyres_id_seq'::regclass);


--
-- TOC entry 3248 (class 2604 OID 25321)
-- Name: validator id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validator ALTER COLUMN id SET DEFAULT nextval('public.validator_id_seq'::regclass);


--
-- TOC entry 3510 (class 0 OID 33243)
-- Dependencies: 217
-- Data for Name: setup; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.setup (id, car_type, name, setup_type, track, aero_id, dampers_id, electronics_id, fuel_strategy_id, mechanical_grip_id, tyres_id, user_id) FROM stdin;
1	0	default_mercedes_imola	0	0	1	1	1	1	1	1	1
2	0	default_mercedes_nurburgring	0	1	2	2	2	2	2	2	1
3	0	default_mercedes_barcelona	0	2	3	3	3	3	3	3	1
\.


--
-- TOC entry 3512 (class 0 OID 33253)
-- Dependencies: 219
-- Data for Name: setup_aero; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.setup_aero (id, front_brake_ducts, front_ride_height, rear_brake_ducts, rear_ride_height, rear_wing, splitter) FROM stdin;
1	4	56	3	77	8	5
2	4	50	4	78	8	5
3	4	50	4	78	8	7
\.


--
-- TOC entry 3514 (class 0 OID 33260)
-- Dependencies: 221
-- Data for Name: setup_dampers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.setup_dampers (id, front_left_bump, front_left_fast_bump, front_left_fast_rebound, front_left_rebound, front_right_bump, front_right_fast_bump, front_right_fast_rebound, front_right_rebound, rear_left_bump, rear_left_fast_bump, rear_left_fast_rebound, rear_left_rebound, rear_right_bump, rear_right_fast_bump, rear_right_fast_rebound, rear_right_rebound) FROM stdin;
1	8	4	6	7	8	4	6	7	6	3	6	7	6	3	6	7
2	5	7	8	7	5	7	8	7	5	6	8	4	5	6	8	4
3	5	7	8	7	5	7	8	7	5	6	8	4	5	6	8	4
\.


--
-- TOC entry 3516 (class 0 OID 33267)
-- Dependencies: 223
-- Data for Name: setup_electronics; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.setup_electronics (id, abs, ecu_map, telemetry_laps, traction_control) FROM stdin;
1	3	1	0	2
2	3	1	0	2
3	3	1	0	2
\.


--
-- TOC entry 3518 (class 0 OID 33274)
-- Dependencies: 225
-- Data for Name: setup_fuel_strategy; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.setup_fuel_strategy (id, front_brakes, fuel, fuel_per_lap, rear_brakes, tyre_type) FROM stdin;
1	1	62	0	1	0
2	2	62	0	2	0
3	2	62	0	2	0
\.


--
-- TOC entry 3520 (class 0 OID 33282)
-- Dependencies: 227
-- Data for Name: setup_mechanical_grip; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.setup_mechanical_grip (id, brake_bias, brake_power, front_anti_roll_bar, front_left_bumpstop_range, front_left_bumpstop_rate, front_left_wheel_rate, front_right_bumpstop_range, front_right_bumpstop_rate, front_right_wheel_rate, preload_differential, rear_anti_roll_bar, rear_left_bumpstop_range, rear_left_bumpstop_rate, rear_left_wheel_rate, rear_right_bumpstop_range, rear_right_bumpstop_rate, rear_right_wheel_rate, steer_ratio) FROM stdin;
1	61	100	8	8	700	130000	8	700	130000	80	4	50	600	107000	50	600	107000	14
2	61.6	100	5	5	600	155000	5	600	155000	60	4	15	600	119000	15	600	119000	14
3	61.6	100	5	5	600	155000	5	600	155000	60	3	17	600	119000	17	600	119000	14
\.


--
-- TOC entry 3522 (class 0 OID 33289)
-- Dependencies: 229
-- Data for Name: setup_tyres; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.setup_tyres (id, caster_left, caster_right, front_left_camber, front_left_toe, front_left_tyre_pressure, front_right_camber, front_right_toe, front_right_tyre_pressure, rear_left_camber, rear_left_toe, rear_left_tyre_pressure, rear_right_camber, rear_right_toe, rear_right_tyre_pressure) FROM stdin;
1	12.1	12.1	-3.4	-0.1	25	-3.4	-0.1	25	-3.2	0.05	25	-3.2	0.05	25
2	12.1	12.1	-4	-0.1	25	-4	-0.1	25	0.1	-3.3	25	0.1	-3.3	25
3	12.1	12.1	-4	-0.1	25	-4	-0.1	25	-3.3	0.1	25	-3.3	0.1	25
\.


--
-- TOC entry 3524 (class 0 OID 33296)
-- Dependencies: 231
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, email, password, role, username) FROM stdin;
1	admin@admin.com	$2a$10$h.ZI50pDChoNxLJ.xCYVSem4da8F08XcU6ID3hsVwS2axhV12SQOy	USER	admin
\.


--
-- TOC entry 3526 (class 0 OID 33306)
-- Dependencies: 233
-- Data for Name: validate_aero; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.validate_aero (id, car, front_brake_ducts_max, front_brake_ducts_min, front_ride_height_max, front_ride_height_min, rear_brake_ducts_max, rear_brake_ducts_min, rear_ride_height_max, rear_ride_height_min, rear_wing_max, rear_wing_min, splitter_max, splitter_min) FROM stdin;
\.


--
-- TOC entry 3528 (class 0 OID 33314)
-- Dependencies: 235
-- Data for Name: validate_dampers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.validate_dampers (id, car, front_bump_max, front_bump_min, front_fast_bump_max, front_fast_bump_min, front_fast_rebound_max, front_fast_rebound_min, front_rebound_max, front_rebound_min, rear_bump_max, rear_bump_min, rear_fast_bump_max, rear_fast_bump_min, rear_fast_rebound_max, rear_fast_rebound_min, rear_rebound_max, rear_rebound_min) FROM stdin;
\.


--
-- TOC entry 3530 (class 0 OID 33322)
-- Dependencies: 237
-- Data for Name: validate_electronics; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.validate_electronics (id, abs_max, abs_min, car, ecu_map_max, ecu_map_min, telemetry_laps_max, telemetry_laps_min, traction_control_max, traction_control_min) FROM stdin;
\.


--
-- TOC entry 3532 (class 0 OID 33330)
-- Dependencies: 239
-- Data for Name: validate_fuel_strategy; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.validate_fuel_strategy (id, brakes_max, brakes_min, car, fuel_max, fuel_min, fuel_per_lap, tyre_type_min) FROM stdin;
\.


--
-- TOC entry 3534 (class 0 OID 33339)
-- Dependencies: 241
-- Data for Name: validate_mechanical_grip; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.validate_mechanical_grip (id, brake_bias_max, brake_bias_min, brake_power, car, front_anti_roll_bar_max, front_anti_roll_bar_min, front_bump_stop_range_max, front_bump_stop_range_min, front_bump_stop_rate_max, front_bump_stop_rate_min, front_wheel_rate_max, front_wheel_rate_min, preload_differential_max, preload_differential_min, rear_anti_roll_bar_max, rear_anti_roll_bar_min, rear_bump_stop_range_max, rear_bump_stop_range_min, rear_bump_stop_rate_max, rear_bump_stop_rate_min, rear_wheel_rate_max, rear_wheel_rate_min, steer_ratio_max, steer_ratio_min) FROM stdin;
\.


--
-- TOC entry 3536 (class 0 OID 33347)
-- Dependencies: 243
-- Data for Name: validate_setup; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.validate_setup (id, car_type, validate_aero_id, validate_dampers_id, validate_electronics_id, validate_fuel_strategy_id, validate_mechanical_grip_id, validate_tyres_id) FROM stdin;
\.


--
-- TOC entry 3538 (class 0 OID 33355)
-- Dependencies: 245
-- Data for Name: validate_tyres; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.validate_tyres (id, car, caster_max, caster_min, front_camber_max, front_camber_min, front_toe_max, front_toe_min, rear_camber_max, rear_camber_min, rear_toe_max, rear_toe_min, tyre_pressure_max, tyre_pressure_min) FROM stdin;
\.


--
-- TOC entry 3508 (class 0 OID 25318)
-- Dependencies: 215
-- Data for Name: validator; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.validator (id, car_type, validate_aero_id, validate_dampers_id, validate_electronics_id, validate_fuel_strategy_id, validate_mechanical_grip_id, validate_tyres_id) FROM stdin;
\.


--
-- TOC entry 3560 (class 0 OID 0)
-- Dependencies: 218
-- Name: setup_aero_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.setup_aero_id_seq', 3, true);


--
-- TOC entry 3561 (class 0 OID 0)
-- Dependencies: 220
-- Name: setup_dampers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.setup_dampers_id_seq', 3, true);


--
-- TOC entry 3562 (class 0 OID 0)
-- Dependencies: 222
-- Name: setup_electronics_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.setup_electronics_id_seq', 3, true);


--
-- TOC entry 3563 (class 0 OID 0)
-- Dependencies: 224
-- Name: setup_fuel_strategy_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.setup_fuel_strategy_id_seq', 3, true);


--
-- TOC entry 3564 (class 0 OID 0)
-- Dependencies: 216
-- Name: setup_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.setup_id_seq', 3, true);


--
-- TOC entry 3565 (class 0 OID 0)
-- Dependencies: 226
-- Name: setup_mechanical_grip_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.setup_mechanical_grip_id_seq', 3, true);


--
-- TOC entry 3566 (class 0 OID 0)
-- Dependencies: 228
-- Name: setup_tyres_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.setup_tyres_id_seq', 3, true);


--
-- TOC entry 3567 (class 0 OID 0)
-- Dependencies: 230
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 1, true);


--
-- TOC entry 3568 (class 0 OID 0)
-- Dependencies: 232
-- Name: validate_aero_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.validate_aero_id_seq', 1, false);


--
-- TOC entry 3569 (class 0 OID 0)
-- Dependencies: 234
-- Name: validate_dampers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.validate_dampers_id_seq', 1, false);


--
-- TOC entry 3570 (class 0 OID 0)
-- Dependencies: 236
-- Name: validate_electronics_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.validate_electronics_id_seq', 1, false);


--
-- TOC entry 3571 (class 0 OID 0)
-- Dependencies: 238
-- Name: validate_fuel_strategy_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.validate_fuel_strategy_id_seq', 1, false);


--
-- TOC entry 3572 (class 0 OID 0)
-- Dependencies: 240
-- Name: validate_mechanical_grip_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.validate_mechanical_grip_id_seq', 1, false);


--
-- TOC entry 3573 (class 0 OID 0)
-- Dependencies: 242
-- Name: validate_setup_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.validate_setup_id_seq', 1, false);


--
-- TOC entry 3574 (class 0 OID 0)
-- Dependencies: 244
-- Name: validate_tyres_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.validate_tyres_id_seq', 1, false);


--
-- TOC entry 3575 (class 0 OID 0)
-- Dependencies: 214
-- Name: validator_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.validator_id_seq', 1, false);


--
-- TOC entry 3307 (class 2606 OID 33258)
-- Name: setup_aero setup_aero_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_aero
    ADD CONSTRAINT setup_aero_pkey PRIMARY KEY (id);


--
-- TOC entry 3309 (class 2606 OID 33265)
-- Name: setup_dampers setup_dampers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_dampers
    ADD CONSTRAINT setup_dampers_pkey PRIMARY KEY (id);


--
-- TOC entry 3311 (class 2606 OID 33272)
-- Name: setup_electronics setup_electronics_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_electronics
    ADD CONSTRAINT setup_electronics_pkey PRIMARY KEY (id);


--
-- TOC entry 3313 (class 2606 OID 33280)
-- Name: setup_fuel_strategy setup_fuel_strategy_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_fuel_strategy
    ADD CONSTRAINT setup_fuel_strategy_pkey PRIMARY KEY (id);


--
-- TOC entry 3315 (class 2606 OID 33287)
-- Name: setup_mechanical_grip setup_mechanical_grip_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_mechanical_grip
    ADD CONSTRAINT setup_mechanical_grip_pkey PRIMARY KEY (id);


--
-- TOC entry 3293 (class 2606 OID 33251)
-- Name: setup setup_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT setup_pkey PRIMARY KEY (id);


--
-- TOC entry 3317 (class 2606 OID 33294)
-- Name: setup_tyres setup_tyres_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_tyres
    ADD CONSTRAINT setup_tyres_pkey PRIMARY KEY (id);


--
-- TOC entry 3279 (class 2606 OID 25342)
-- Name: validator uk_19wm5g12wtaicdk24t8c7re0x; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validator
    ADD CONSTRAINT uk_19wm5g12wtaicdk24t8c7re0x UNIQUE (validate_aero_id);


--
-- TOC entry 3335 (class 2606 OID 33379)
-- Name: validate_setup uk_1jglccqgsgopfj336j9jjf8tf; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT uk_1jglccqgsgopfj336j9jjf8tf UNIQUE (car_type);


--
-- TOC entry 3281 (class 2606 OID 25348)
-- Name: validator uk_2oyn2nlgs0hyibtq2l66eeyv8; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validator
    ADD CONSTRAINT uk_2oyn2nlgs0hyibtq2l66eeyv8 UNIQUE (validate_fuel_strategy_id);


--
-- TOC entry 3319 (class 2606 OID 33375)
-- Name: users uk_6dotkott2kjsp8vw4d0m25fb7; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email);


--
-- TOC entry 3295 (class 2606 OID 33367)
-- Name: setup uk_8bn9e69k8d91ucvh0dlhqct2v; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT uk_8bn9e69k8d91ucvh0dlhqct2v UNIQUE (electronics_id);


--
-- TOC entry 3297 (class 2606 OID 33371)
-- Name: setup uk_dsyy9tjyn0go5gy9wjiqmw5xy; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT uk_dsyy9tjyn0go5gy9wjiqmw5xy UNIQUE (mechanical_grip_id);


--
-- TOC entry 3337 (class 2606 OID 33387)
-- Name: validate_setup uk_epx919bfk8csegu87t6gfdw55; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT uk_epx919bfk8csegu87t6gfdw55 UNIQUE (validate_fuel_strategy_id);


--
-- TOC entry 3299 (class 2606 OID 33365)
-- Name: setup uk_ff99vvf8tku6v5963w9ckuqti; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT uk_ff99vvf8tku6v5963w9ckuqti UNIQUE (dampers_id);


--
-- TOC entry 3283 (class 2606 OID 25352)
-- Name: validator uk_fym54nhmgy0wdwbihml5j142x; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validator
    ADD CONSTRAINT uk_fym54nhmgy0wdwbihml5j142x UNIQUE (validate_tyres_id);


--
-- TOC entry 3339 (class 2606 OID 33381)
-- Name: validate_setup uk_gw9me8r8mcmf77bo7ivhnsls2; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT uk_gw9me8r8mcmf77bo7ivhnsls2 UNIQUE (validate_aero_id);


--
-- TOC entry 3341 (class 2606 OID 33385)
-- Name: validate_setup uk_hwjqja9ancokd7dvvltih6lsc; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT uk_hwjqja9ancokd7dvvltih6lsc UNIQUE (validate_electronics_id);


--
-- TOC entry 3343 (class 2606 OID 33383)
-- Name: validate_setup uk_hx4nyqj4pibo1tet70xjspdut; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT uk_hx4nyqj4pibo1tet70xjspdut UNIQUE (validate_dampers_id);


--
-- TOC entry 3301 (class 2606 OID 33373)
-- Name: setup uk_i4bhalx4pwq4b8y2unf8qpj68; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT uk_i4bhalx4pwq4b8y2unf8qpj68 UNIQUE (tyres_id);


--
-- TOC entry 3303 (class 2606 OID 33363)
-- Name: setup uk_k3tphqr01r7fw7lk8hogh3mvr; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT uk_k3tphqr01r7fw7lk8hogh3mvr UNIQUE (aero_id);


--
-- TOC entry 3285 (class 2606 OID 25350)
-- Name: validator uk_kgyxcgnvyh1pbt49q3tufp0nr; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validator
    ADD CONSTRAINT uk_kgyxcgnvyh1pbt49q3tufp0nr UNIQUE (validate_mechanical_grip_id);


--
-- TOC entry 3287 (class 2606 OID 25344)
-- Name: validator uk_mifi5muvcatwk5rvhhehuxvfg; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validator
    ADD CONSTRAINT uk_mifi5muvcatwk5rvhhehuxvfg UNIQUE (validate_dampers_id);


--
-- TOC entry 3289 (class 2606 OID 25346)
-- Name: validator uk_qox9au66y0ralttbmc0gdh4lr; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validator
    ADD CONSTRAINT uk_qox9au66y0ralttbmc0gdh4lr UNIQUE (validate_electronics_id);


--
-- TOC entry 3321 (class 2606 OID 33377)
-- Name: users uk_r43af9ap4edm43mmtq01oddj6; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_r43af9ap4edm43mmtq01oddj6 UNIQUE (username);


--
-- TOC entry 3345 (class 2606 OID 33391)
-- Name: validate_setup uk_s20d88rsesg2dvkx8nix4twt3; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT uk_s20d88rsesg2dvkx8nix4twt3 UNIQUE (validate_tyres_id);


--
-- TOC entry 3305 (class 2606 OID 33369)
-- Name: setup uk_sfovfatbat6jrwfjg4fh733gn; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT uk_sfovfatbat6jrwfjg4fh733gn UNIQUE (fuel_strategy_id);


--
-- TOC entry 3347 (class 2606 OID 33389)
-- Name: validate_setup uk_yiskkerh2xfjcayokr3fc7h4; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT uk_yiskkerh2xfjcayokr3fc7h4 UNIQUE (validate_mechanical_grip_id);


--
-- TOC entry 3323 (class 2606 OID 33304)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 3325 (class 2606 OID 33312)
-- Name: validate_aero validate_aero_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_aero
    ADD CONSTRAINT validate_aero_pkey PRIMARY KEY (id);


--
-- TOC entry 3327 (class 2606 OID 33320)
-- Name: validate_dampers validate_dampers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_dampers
    ADD CONSTRAINT validate_dampers_pkey PRIMARY KEY (id);


--
-- TOC entry 3329 (class 2606 OID 33328)
-- Name: validate_electronics validate_electronics_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_electronics
    ADD CONSTRAINT validate_electronics_pkey PRIMARY KEY (id);


--
-- TOC entry 3331 (class 2606 OID 33337)
-- Name: validate_fuel_strategy validate_fuel_strategy_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_fuel_strategy
    ADD CONSTRAINT validate_fuel_strategy_pkey PRIMARY KEY (id);


--
-- TOC entry 3333 (class 2606 OID 33345)
-- Name: validate_mechanical_grip validate_mechanical_grip_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_mechanical_grip
    ADD CONSTRAINT validate_mechanical_grip_pkey PRIMARY KEY (id);


--
-- TOC entry 3349 (class 2606 OID 33353)
-- Name: validate_setup validate_setup_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT validate_setup_pkey PRIMARY KEY (id);


--
-- TOC entry 3351 (class 2606 OID 33361)
-- Name: validate_tyres validate_tyres_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_tyres
    ADD CONSTRAINT validate_tyres_pkey PRIMARY KEY (id);


--
-- TOC entry 3291 (class 2606 OID 25324)
-- Name: validator validator_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validator
    ADD CONSTRAINT validator_pkey PRIMARY KEY (id);


--
-- TOC entry 3359 (class 2606 OID 33437)
-- Name: validate_setup fk368d8hxhmu3jkyptklxi91dor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT fk368d8hxhmu3jkyptklxi91dor FOREIGN KEY (validate_electronics_id) REFERENCES public.validate_electronics(id);


--
-- TOC entry 3360 (class 2606 OID 33452)
-- Name: validate_setup fk3kgao5hwj8py5hgwi5cbk2xvk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT fk3kgao5hwj8py5hgwi5cbk2xvk FOREIGN KEY (validate_tyres_id) REFERENCES public.validate_tyres(id);


--
-- TOC entry 3361 (class 2606 OID 33427)
-- Name: validate_setup fk6ck9q4ciwx8amnh7fvjklhqh8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT fk6ck9q4ciwx8amnh7fvjklhqh8 FOREIGN KEY (validate_aero_id) REFERENCES public.validate_aero(id);


--
-- TOC entry 3362 (class 2606 OID 33432)
-- Name: validate_setup fk712lngviykjx08c9udlvthp41; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT fk712lngviykjx08c9udlvthp41 FOREIGN KEY (validate_dampers_id) REFERENCES public.validate_dampers(id);


--
-- TOC entry 3352 (class 2606 OID 33392)
-- Name: setup fkb4qurssam4v0a24f8fvudbt1g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT fkb4qurssam4v0a24f8fvudbt1g FOREIGN KEY (aero_id) REFERENCES public.setup_aero(id);


--
-- TOC entry 3353 (class 2606 OID 33412)
-- Name: setup fkgowc0la6v4oggmwodg5d8dvdx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT fkgowc0la6v4oggmwodg5d8dvdx FOREIGN KEY (mechanical_grip_id) REFERENCES public.setup_mechanical_grip(id);


--
-- TOC entry 3354 (class 2606 OID 33407)
-- Name: setup fkguflp1qghxiu8xkolmn1diu2c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT fkguflp1qghxiu8xkolmn1diu2c FOREIGN KEY (fuel_strategy_id) REFERENCES public.setup_fuel_strategy(id);


--
-- TOC entry 3363 (class 2606 OID 33447)
-- Name: validate_setup fkhghw6aly2745g35oi2xqjh7gm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT fkhghw6aly2745g35oi2xqjh7gm FOREIGN KEY (validate_mechanical_grip_id) REFERENCES public.validate_mechanical_grip(id);


--
-- TOC entry 3355 (class 2606 OID 33417)
-- Name: setup fkjwwepomc3tw206g8ff15wjq7g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT fkjwwepomc3tw206g8ff15wjq7g FOREIGN KEY (tyres_id) REFERENCES public.setup_tyres(id);


--
-- TOC entry 3356 (class 2606 OID 33397)
-- Name: setup fkmgr8li9ptse1nvwakjubato2j; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT fkmgr8li9ptse1nvwakjubato2j FOREIGN KEY (dampers_id) REFERENCES public.setup_dampers(id);


--
-- TOC entry 3364 (class 2606 OID 33442)
-- Name: validate_setup fkrh6k0blkuis67thx6ajp6kpe4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT fkrh6k0blkuis67thx6ajp6kpe4 FOREIGN KEY (validate_fuel_strategy_id) REFERENCES public.validate_fuel_strategy(id);


--
-- TOC entry 3357 (class 2606 OID 33402)
-- Name: setup fksh4rfjcbc303lhtq90ll2tdpq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT fksh4rfjcbc303lhtq90ll2tdpq FOREIGN KEY (electronics_id) REFERENCES public.setup_electronics(id);


--
-- TOC entry 3358 (class 2606 OID 33422)
-- Name: setup fkt7y23ji1r2n6d75vo32sicu5k; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT fkt7y23ji1r2n6d75vo32sicu5k FOREIGN KEY (user_id) REFERENCES public.users(id);


-- Completed on 2023-09-18 11:30:24

--
-- PostgreSQL database dump complete
--

