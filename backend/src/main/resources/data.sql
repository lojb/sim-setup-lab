--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2023-10-27 11:00:45

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

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

DROP SCHEMA IF EXISTS public CASCADE;

CREATE SCHEMA IF NOT EXISTS public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 4987 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 216 (class 1259 OID 16400)
-- Name: setup; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.setup (
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
-- TOC entry 218 (class 1259 OID 16410)
-- Name: setup_aero; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.setup_aero (
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
-- TOC entry 217 (class 1259 OID 16409)
-- Name: setup_aero_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.setup_aero_id_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.setup_aero_id_seq OWNER TO postgres;

--
-- TOC entry 4988 (class 0 OID 0)
-- Dependencies: 217
-- Name: setup_aero_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.setup_aero_id_seq OWNED BY public.setup_aero.id;


--
-- TOC entry 245 (class 1259 OID 16607)
-- Name: setup_aero_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.setup_aero_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.setup_aero_seq OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16417)
-- Name: setup_dampers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.setup_dampers (
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
-- TOC entry 219 (class 1259 OID 16416)
-- Name: setup_dampers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.setup_dampers_id_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.setup_dampers_id_seq OWNER TO postgres;

--
-- TOC entry 4989 (class 0 OID 0)
-- Dependencies: 219
-- Name: setup_dampers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.setup_dampers_id_seq OWNED BY public.setup_dampers.id;


--
-- TOC entry 246 (class 1259 OID 16608)
-- Name: setup_dampers_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.setup_dampers_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.setup_dampers_seq OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16424)
-- Name: setup_electronics; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.setup_electronics (
                                                        id bigint NOT NULL,
                                                        abs integer NOT NULL,
                                                        ecu_map integer NOT NULL,
                                                        telemetry_laps integer NOT NULL,
                                                        traction_control integer NOT NULL
);


ALTER TABLE public.setup_electronics OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16423)
-- Name: setup_electronics_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.setup_electronics_id_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.setup_electronics_id_seq OWNER TO postgres;

--
-- TOC entry 4990 (class 0 OID 0)
-- Dependencies: 221
-- Name: setup_electronics_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.setup_electronics_id_seq OWNED BY public.setup_electronics.id;


--
-- TOC entry 247 (class 1259 OID 16609)
-- Name: setup_electronics_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.setup_electronics_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.setup_electronics_seq OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16431)
-- Name: setup_fuel_strategy; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.setup_fuel_strategy (
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
-- TOC entry 223 (class 1259 OID 16430)
-- Name: setup_fuel_strategy_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.setup_fuel_strategy_id_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.setup_fuel_strategy_id_seq OWNER TO postgres;

--
-- TOC entry 4991 (class 0 OID 0)
-- Dependencies: 223
-- Name: setup_fuel_strategy_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.setup_fuel_strategy_id_seq OWNED BY public.setup_fuel_strategy.id;


--
-- TOC entry 248 (class 1259 OID 16610)
-- Name: setup_fuel_strategy_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.setup_fuel_strategy_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.setup_fuel_strategy_seq OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16399)
-- Name: setup_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.setup_id_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.setup_id_seq OWNER TO postgres;

--
-- TOC entry 4992 (class 0 OID 0)
-- Dependencies: 215
-- Name: setup_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.setup_id_seq OWNED BY public.setup.id;


--
-- TOC entry 226 (class 1259 OID 16439)
-- Name: setup_mechanical_grip; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.setup_mechanical_grip (
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
-- TOC entry 225 (class 1259 OID 16438)
-- Name: setup_mechanical_grip_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.setup_mechanical_grip_id_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.setup_mechanical_grip_id_seq OWNER TO postgres;

--
-- TOC entry 4993 (class 0 OID 0)
-- Dependencies: 225
-- Name: setup_mechanical_grip_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.setup_mechanical_grip_id_seq OWNED BY public.setup_mechanical_grip.id;


--
-- TOC entry 249 (class 1259 OID 16611)
-- Name: setup_mechanical_grip_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.setup_mechanical_grip_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.setup_mechanical_grip_seq OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 16446)
-- Name: setup_tyres; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.setup_tyres (
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
-- TOC entry 227 (class 1259 OID 16445)
-- Name: setup_tyres_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.setup_tyres_id_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.setup_tyres_id_seq OWNER TO postgres;

--
-- TOC entry 4994 (class 0 OID 0)
-- Dependencies: 227
-- Name: setup_tyres_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.setup_tyres_id_seq OWNED BY public.setup_tyres.id;


--
-- TOC entry 250 (class 1259 OID 16612)
-- Name: setup_tyres_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.setup_tyres_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.setup_tyres_seq OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 16453)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.users (
                                            id bigint NOT NULL,
                                            email character varying(255),
                                            password character varying(255),
                                            role character varying(255),
                                            username character varying(255),
                                            CONSTRAINT users_role_check CHECK (((role)::text = ANY ((ARRAY['USER'::character varying, 'ADMIN'::character varying])::text[])))
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 16452)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.users_id_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 4995 (class 0 OID 0)
-- Dependencies: 229
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 232 (class 1259 OID 16463)
-- Name: validate_aero; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.validate_aero (
                                                    id bigint NOT NULL,
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
                                                    splitter_min integer NOT NULL
);


ALTER TABLE public.validate_aero OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 16462)
-- Name: validate_aero_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.validate_aero_id_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.validate_aero_id_seq OWNER TO postgres;

--
-- TOC entry 4996 (class 0 OID 0)
-- Dependencies: 231
-- Name: validate_aero_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.validate_aero_id_seq OWNED BY public.validate_aero.id;


--
-- TOC entry 234 (class 1259 OID 16470)
-- Name: validate_dampers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.validate_dampers (
                                                       id bigint NOT NULL,
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
                                                       rear_rebound_min integer NOT NULL
);


ALTER TABLE public.validate_dampers OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 16469)
-- Name: validate_dampers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.validate_dampers_id_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.validate_dampers_id_seq OWNER TO postgres;

--
-- TOC entry 4997 (class 0 OID 0)
-- Dependencies: 233
-- Name: validate_dampers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.validate_dampers_id_seq OWNED BY public.validate_dampers.id;


--
-- TOC entry 236 (class 1259 OID 16477)
-- Name: validate_electronics; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.validate_electronics (
                                                           id bigint NOT NULL,
                                                           abs_max integer NOT NULL,
                                                           abs_min integer NOT NULL,
                                                           ecu_map_max integer NOT NULL,
                                                           ecu_map_min integer NOT NULL,
                                                           telemetry_laps_max integer NOT NULL,
                                                           telemetry_laps_min integer NOT NULL,
                                                           traction_control_max integer NOT NULL,
                                                           traction_control_min integer NOT NULL
);


ALTER TABLE public.validate_electronics OWNER TO postgres;

--
-- TOC entry 235 (class 1259 OID 16476)
-- Name: validate_electronics_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.validate_electronics_id_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.validate_electronics_id_seq OWNER TO postgres;

--
-- TOC entry 4998 (class 0 OID 0)
-- Dependencies: 235
-- Name: validate_electronics_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.validate_electronics_id_seq OWNED BY public.validate_electronics.id;


--
-- TOC entry 238 (class 1259 OID 16484)
-- Name: validate_fuel_strategy; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.validate_fuel_strategy (
                                                             id bigint NOT NULL,
                                                             brakes_max integer NOT NULL,
                                                             brakes_min integer NOT NULL,
                                                             fuel_max integer NOT NULL,
                                                             fuel_min integer NOT NULL,
                                                             fuel_per_lap double precision NOT NULL,
                                                             tyre_type smallint,
                                                             CONSTRAINT validate_fuel_strategy_tyre_type_check CHECK (((tyre_type >= 0) AND (tyre_type <= 1)))
);


ALTER TABLE public.validate_fuel_strategy OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 16483)
-- Name: validate_fuel_strategy_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.validate_fuel_strategy_id_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.validate_fuel_strategy_id_seq OWNER TO postgres;

--
-- TOC entry 4999 (class 0 OID 0)
-- Dependencies: 237
-- Name: validate_fuel_strategy_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.validate_fuel_strategy_id_seq OWNED BY public.validate_fuel_strategy.id;


--
-- TOC entry 240 (class 1259 OID 16492)
-- Name: validate_mechanical_grip; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.validate_mechanical_grip (
                                                               id bigint NOT NULL,
                                                               brake_bias_max real NOT NULL,
                                                               brake_bias_min real NOT NULL,
                                                               brake_power integer NOT NULL,
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
                                                               steer_ratio_min integer NOT NULL
);


ALTER TABLE public.validate_mechanical_grip OWNER TO postgres;

--
-- TOC entry 239 (class 1259 OID 16491)
-- Name: validate_mechanical_grip_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.validate_mechanical_grip_id_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.validate_mechanical_grip_id_seq OWNER TO postgres;

--
-- TOC entry 5000 (class 0 OID 0)
-- Dependencies: 239
-- Name: validate_mechanical_grip_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.validate_mechanical_grip_id_seq OWNED BY public.validate_mechanical_grip.id;


--
-- TOC entry 242 (class 1259 OID 16499)
-- Name: validate_setup; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.validate_setup (
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
-- TOC entry 241 (class 1259 OID 16498)
-- Name: validate_setup_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.validate_setup_id_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.validate_setup_id_seq OWNER TO postgres;

--
-- TOC entry 5001 (class 0 OID 0)
-- Dependencies: 241
-- Name: validate_setup_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.validate_setup_id_seq OWNED BY public.validate_setup.id;


--
-- TOC entry 244 (class 1259 OID 16507)
-- Name: validate_tyres; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.validate_tyres (
                                                     id bigint NOT NULL,
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
                                                     tyre_pressure_min real NOT NULL
);


ALTER TABLE public.validate_tyres OWNER TO postgres;

--
-- TOC entry 243 (class 1259 OID 16506)
-- Name: validate_tyres_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS public.validate_tyres_id_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.validate_tyres_id_seq OWNER TO postgres;

--
-- TOC entry 5002 (class 0 OID 0)
-- Dependencies: 243
-- Name: validate_tyres_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.validate_tyres_id_seq OWNED BY public.validate_tyres.id;


--
-- TOC entry 4710 (class 2604 OID 16403)
-- Name: setup id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup ALTER COLUMN id SET DEFAULT nextval('public.setup_id_seq'::regclass);


--
-- TOC entry 4711 (class 2604 OID 16413)
-- Name: setup_aero id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_aero ALTER COLUMN id SET DEFAULT nextval('public.setup_aero_id_seq'::regclass);


--
-- TOC entry 4712 (class 2604 OID 16420)
-- Name: setup_dampers id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_dampers ALTER COLUMN id SET DEFAULT nextval('public.setup_dampers_id_seq'::regclass);


--
-- TOC entry 4713 (class 2604 OID 16427)
-- Name: setup_electronics id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_electronics ALTER COLUMN id SET DEFAULT nextval('public.setup_electronics_id_seq'::regclass);


--
-- TOC entry 4714 (class 2604 OID 16434)
-- Name: setup_fuel_strategy id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_fuel_strategy ALTER COLUMN id SET DEFAULT nextval('public.setup_fuel_strategy_id_seq'::regclass);


--
-- TOC entry 4715 (class 2604 OID 16442)
-- Name: setup_mechanical_grip id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_mechanical_grip ALTER COLUMN id SET DEFAULT nextval('public.setup_mechanical_grip_id_seq'::regclass);


--
-- TOC entry 4716 (class 2604 OID 16449)
-- Name: setup_tyres id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_tyres ALTER COLUMN id SET DEFAULT nextval('public.setup_tyres_id_seq'::regclass);


--
-- TOC entry 4717 (class 2604 OID 16456)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 4718 (class 2604 OID 16466)
-- Name: validate_aero id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_aero ALTER COLUMN id SET DEFAULT nextval('public.validate_aero_id_seq'::regclass);


--
-- TOC entry 4719 (class 2604 OID 16473)
-- Name: validate_dampers id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_dampers ALTER COLUMN id SET DEFAULT nextval('public.validate_dampers_id_seq'::regclass);


--
-- TOC entry 4720 (class 2604 OID 16480)
-- Name: validate_electronics id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_electronics ALTER COLUMN id SET DEFAULT nextval('public.validate_electronics_id_seq'::regclass);


--
-- TOC entry 4721 (class 2604 OID 16487)
-- Name: validate_fuel_strategy id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_fuel_strategy ALTER COLUMN id SET DEFAULT nextval('public.validate_fuel_strategy_id_seq'::regclass);


--
-- TOC entry 4722 (class 2604 OID 16495)
-- Name: validate_mechanical_grip id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_mechanical_grip ALTER COLUMN id SET DEFAULT nextval('public.validate_mechanical_grip_id_seq'::regclass);


--
-- TOC entry 4723 (class 2604 OID 16502)
-- Name: validate_setup id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup ALTER COLUMN id SET DEFAULT nextval('public.validate_setup_id_seq'::regclass);


--
-- TOC entry 4724 (class 2604 OID 16510)
-- Name: validate_tyres id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_tyres ALTER COLUMN id SET DEFAULT nextval('public.validate_tyres_id_seq'::regclass);


--
-- TOC entry 4947 (class 0 OID 16400)
-- Dependencies: 216
-- Data for Name: setup; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.setup VALUES (1, 0, 'default_mercedes_imola', 1, 0, 1, 1, 1, 1, 1, 1, 1) ON CONFLICT DO NOTHING;
INSERT INTO public.setup VALUES (2, 0, 'default_mercedes_nurburgring', 1, 1, 2, 2, 2, 2, 2, 2, 1) ON CONFLICT DO NOTHING;
INSERT INTO public.setup VALUES (3, 0, 'default_mercedes_barcelona', 1, 2, 3, 3, 3, 3, 3, 3, 1) ON CONFLICT DO NOTHING;


--
-- TOC entry 4949 (class 0 OID 16410)
-- Dependencies: 218
-- Data for Name: setup_aero; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.setup_aero VALUES (1, 4, 56, 3, 77, 8, 5) ON CONFLICT DO NOTHING;
INSERT INTO public.setup_aero VALUES (2, 4, 50, 4, 78, 8, 5) ON CONFLICT DO NOTHING;
INSERT INTO public.setup_aero VALUES (3, 4, 50, 4, 78, 8, 7) ON CONFLICT DO NOTHING;


--
-- TOC entry 4951 (class 0 OID 16417)
-- Dependencies: 220
-- Data for Name: setup_dampers; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.setup_dampers VALUES (1, 8, 4, 6, 7, 8, 4, 6, 7, 6, 3, 6, 7, 6, 3, 6, 7) ON CONFLICT DO NOTHING;
INSERT INTO public.setup_dampers VALUES (2, 5, 7, 8, 7, 5, 7, 8, 7, 5, 6, 8, 4, 5, 6, 8, 4) ON CONFLICT DO NOTHING;
INSERT INTO public.setup_dampers VALUES (3, 5, 7, 8, 7, 5, 7, 8, 7, 5, 6, 8, 4, 5, 6, 8, 4) ON CONFLICT DO NOTHING;


--
-- TOC entry 4953 (class 0 OID 16424)
-- Dependencies: 222
-- Data for Name: setup_electronics; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.setup_electronics VALUES (1, 3, 1, 0, 2) ON CONFLICT DO NOTHING;
INSERT INTO public.setup_electronics VALUES (2, 3, 1, 0, 2) ON CONFLICT DO NOTHING;
INSERT INTO public.setup_electronics VALUES (3, 3, 1, 0, 2) ON CONFLICT DO NOTHING;


--
-- TOC entry 4955 (class 0 OID 16431)
-- Dependencies: 224
-- Data for Name: setup_fuel_strategy; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.setup_fuel_strategy VALUES (1, 1, 62, 0, 1, 0) ON CONFLICT DO NOTHING;
INSERT INTO public.setup_fuel_strategy VALUES (2, 2, 62, 0, 2, 0) ON CONFLICT DO NOTHING;
INSERT INTO public.setup_fuel_strategy VALUES (3, 2, 62, 0, 2, 0) ON CONFLICT DO NOTHING;


--
-- TOC entry 4957 (class 0 OID 16439)
-- Dependencies: 226
-- Data for Name: setup_mechanical_grip; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.setup_mechanical_grip VALUES (1, 61, 100, 8, 8, 700, 130000, 8, 700, 130000, 80, 4, 50, 600, 107000, 50, 600, 107000, 14) ON CONFLICT DO NOTHING;
INSERT INTO public.setup_mechanical_grip VALUES (2, 61.6, 100, 5, 5, 600, 155000, 5, 600, 155000, 60, 4, 15, 600, 119000, 15, 600, 119000, 14) ON CONFLICT DO NOTHING;
INSERT INTO public.setup_mechanical_grip VALUES (3, 61.6, 100, 5, 5, 600, 155000, 5, 600, 155000, 60, 3, 17, 600, 119000, 17, 600, 119000, 14) ON CONFLICT DO NOTHING;


--
-- TOC entry 4959 (class 0 OID 16446)
-- Dependencies: 228
-- Data for Name: setup_tyres; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.setup_tyres VALUES (1, 12.1, 12.1, -3.4, -0.1, 25, -3.4, -0.1, 25, -3.2, 0.05, 25, -3.2, 0.05, 25) ON CONFLICT DO NOTHING;
INSERT INTO public.setup_tyres VALUES (2, 12.1, 12.1, -4, -0.1, 25, -4, -0.1, 25, 0.1, -3.3, 25, 0.1, -3.3, 25) ON CONFLICT DO NOTHING;
INSERT INTO public.setup_tyres VALUES (3, 12.1, 12.1, -4, -0.1, 25, -4, -0.1, 25, -3.3, 0.1, 25, -3.3, 0.1, 25) ON CONFLICT DO NOTHING;


--
-- TOC entry 4961 (class 0 OID 16453)
-- Dependencies: 230
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users VALUES (1, 'admin@admin.com', '$2a$10$w3PQa6ULGXJsEblqOTpN6OiJfQ.B8Rb0Sxkp38U9DAR4UI5KaPYqG', 'ADMIN', 'admin') ON CONFLICT DO NOTHING;


--
-- TOC entry 4963 (class 0 OID 16463)
-- Dependencies: 232
-- Data for Name: validate_aero; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.validate_aero VALUES (1, 6, 0, 88, 50, 6, 0, 90, 67, 10, 1, 11, 1) ON CONFLICT DO NOTHING;
INSERT INTO public.validate_aero VALUES (2, 6, 0, 80, 50, 6, 0, 105, 64, 12, 1, 3, 0) ON CONFLICT DO NOTHING;
INSERT INTO public.validate_aero VALUES (3, 6, 0, 85, 53, 6, 0, 90, 55, 12, 0, 0, 0) ON CONFLICT DO NOTHING;


--
-- TOC entry 4965 (class 0 OID 16470)
-- Dependencies: 234
-- Data for Name: validate_dampers; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.validate_dampers VALUES (1, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0) ON CONFLICT DO NOTHING;
INSERT INTO public.validate_dampers VALUES (2, 40, 0, 39, 0, 39, 0, 40, 0, 40, 0, 39, 0, 39, 0, 40, 0) ON CONFLICT DO NOTHING;
INSERT INTO public.validate_dampers VALUES (3, 17, 0, 12, 0, 12, 0, 17, 0, 17, 0, 12, 0, 12, 0, 17, 0) ON CONFLICT DO NOTHING;


--
-- TOC entry 4967 (class 0 OID 16477)
-- Dependencies: 236
-- Data for Name: validate_electronics; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.validate_electronics VALUES (1, 10, 0, 3, 1, 99, 0, 11, 0) ON CONFLICT DO NOTHING;
INSERT INTO public.validate_electronics VALUES (2, 12, 0, 13, 1, 99, 0, 12, 0) ON CONFLICT DO NOTHING;
INSERT INTO public.validate_electronics VALUES (3, 11, 0, 10, 1, 99, 0, 11, 0) ON CONFLICT DO NOTHING;


--
-- TOC entry 4969 (class 0 OID 16484)
-- Dependencies: 238
-- Data for Name: validate_fuel_strategy; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.validate_fuel_strategy VALUES (1, 4, 1, 108, 2, 0, 0) ON CONFLICT DO NOTHING;
INSERT INTO public.validate_fuel_strategy VALUES (2, 4, 1, 120, 2, 0, 0) ON CONFLICT DO NOTHING;
INSERT INTO public.validate_fuel_strategy VALUES (3, 4, 1, 120, 2, 0, 0) ON CONFLICT DO NOTHING;


--
-- TOC entry 4971 (class 0 OID 16492)
-- Dependencies: 240
-- Data for Name: validate_mechanical_grip; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.validate_mechanical_grip VALUES (1, 71, 50, 100, 10, 0, 46, 0, 2500, 300, 202000, 130000, 300, 20, 13, 0, 76, 0, 2500, 300, 131000, 71000, 17, 11) ON CONFLICT DO NOTHING;
INSERT INTO public.validate_mechanical_grip VALUES (2, 68, 47, 100, 11, 0, 40, 0, 2500, 300, 230000, 118000, 160, 20, 14, 0, 30, 0, 2500, 300, 209000, 83000, 17, 11) ON CONFLICT DO NOTHING;
INSERT INTO public.validate_mechanical_grip VALUES (3, 64, 43, 100, 6, 0, 49, 0, 2500, 300, 173500, 100500, 300, 20, 6, 0, 50, 0, 2500, 300, 237000, 137000, 17, 11) ON CONFLICT DO NOTHING;


--
-- TOC entry 4973 (class 0 OID 16499)
-- Dependencies: 242
-- Data for Name: validate_setup; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.validate_setup VALUES (1, 0, 1, 1, 1, 1, 1, 1) ON CONFLICT DO NOTHING;
INSERT INTO public.validate_setup VALUES (2, 1, 2, 2, 2, 2, 2, 2) ON CONFLICT DO NOTHING;
INSERT INTO public.validate_setup VALUES (3, 2, 3, 3, 3, 3, 3, 3) ON CONFLICT DO NOTHING;


--
-- TOC entry 4975 (class 0 OID 16507)
-- Dependencies: 244
-- Data for Name: validate_tyres; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.validate_tyres VALUES (2, 16.3, 5.3, -1.5, -4, 0.48, -0.48, -1, -3.5, 0.4, -0.1, 35, 20.3) ON CONFLICT DO NOTHING;
INSERT INTO public.validate_tyres VALUES (3, 12.4, 6.5, -1.5, -4, 0.4, -0.4, -1, -3.5, 0.4, -0.4, 35, 20.3) ON CONFLICT DO NOTHING;
INSERT INTO public.validate_tyres VALUES (1, 14.1, 6, -1.5, -4, 0.4, -0.4, -1, -3.5, 0.4, -0.4, 35, 20.3) ON CONFLICT DO NOTHING;


--
-- TOC entry 4747 (class 2606 OID 16415)
-- Name: setup_aero setup_aero_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_aero
    ADD CONSTRAINT setup_aero_pkey PRIMARY KEY (id);


--
-- TOC entry 4749 (class 2606 OID 16422)
-- Name: setup_dampers setup_dampers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_dampers
    ADD CONSTRAINT setup_dampers_pkey PRIMARY KEY (id);


--
-- TOC entry 4751 (class 2606 OID 16429)
-- Name: setup_electronics setup_electronics_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_electronics
    ADD CONSTRAINT setup_electronics_pkey PRIMARY KEY (id);


--
-- TOC entry 4753 (class 2606 OID 16437)
-- Name: setup_fuel_strategy setup_fuel_strategy_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_fuel_strategy
    ADD CONSTRAINT setup_fuel_strategy_pkey PRIMARY KEY (id);


--
-- TOC entry 4755 (class 2606 OID 16444)
-- Name: setup_mechanical_grip setup_mechanical_grip_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_mechanical_grip
    ADD CONSTRAINT setup_mechanical_grip_pkey PRIMARY KEY (id);


--
-- TOC entry 4733 (class 2606 OID 16408)
-- Name: setup setup_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT setup_pkey PRIMARY KEY (id);


--
-- TOC entry 4757 (class 2606 OID 16451)
-- Name: setup_tyres setup_tyres_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup_tyres
    ADD CONSTRAINT setup_tyres_pkey PRIMARY KEY (id);


--
-- TOC entry 4759 (class 2606 OID 16526)
-- Name: users uk_6dotkott2kjsp8vw4d0m25fb7; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email);


--
-- TOC entry 4735 (class 2606 OID 16518)
-- Name: setup uk_8bn9e69k8d91ucvh0dlhqct2v; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT uk_8bn9e69k8d91ucvh0dlhqct2v UNIQUE (electronics_id);


--
-- TOC entry 4737 (class 2606 OID 16522)
-- Name: setup uk_dsyy9tjyn0go5gy9wjiqmw5xy; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT uk_dsyy9tjyn0go5gy9wjiqmw5xy UNIQUE (mechanical_grip_id);


--
-- TOC entry 4775 (class 2606 OID 16536)
-- Name: validate_setup uk_epx919bfk8csegu87t6gfdw55; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT uk_epx919bfk8csegu87t6gfdw55 UNIQUE (validate_fuel_strategy_id);


--
-- TOC entry 4739 (class 2606 OID 16516)
-- Name: setup uk_ff99vvf8tku6v5963w9ckuqti; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT uk_ff99vvf8tku6v5963w9ckuqti UNIQUE (dampers_id);


--
-- TOC entry 4777 (class 2606 OID 16530)
-- Name: validate_setup uk_gw9me8r8mcmf77bo7ivhnsls2; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT uk_gw9me8r8mcmf77bo7ivhnsls2 UNIQUE (validate_aero_id);


--
-- TOC entry 4779 (class 2606 OID 16534)
-- Name: validate_setup uk_hwjqja9ancokd7dvvltih6lsc; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT uk_hwjqja9ancokd7dvvltih6lsc UNIQUE (validate_electronics_id);


--
-- TOC entry 4781 (class 2606 OID 16532)
-- Name: validate_setup uk_hx4nyqj4pibo1tet70xjspdut; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT uk_hx4nyqj4pibo1tet70xjspdut UNIQUE (validate_dampers_id);


--
-- TOC entry 4741 (class 2606 OID 16524)
-- Name: setup uk_i4bhalx4pwq4b8y2unf8qpj68; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT uk_i4bhalx4pwq4b8y2unf8qpj68 UNIQUE (tyres_id);


--
-- TOC entry 4743 (class 2606 OID 16514)
-- Name: setup uk_k3tphqr01r7fw7lk8hogh3mvr; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT uk_k3tphqr01r7fw7lk8hogh3mvr UNIQUE (aero_id);


--
-- TOC entry 4761 (class 2606 OID 16528)
-- Name: users uk_r43af9ap4edm43mmtq01oddj6; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_r43af9ap4edm43mmtq01oddj6 UNIQUE (username);


--
-- TOC entry 4783 (class 2606 OID 16540)
-- Name: validate_setup uk_s20d88rsesg2dvkx8nix4twt3; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT uk_s20d88rsesg2dvkx8nix4twt3 UNIQUE (validate_tyres_id);


--
-- TOC entry 4745 (class 2606 OID 16520)
-- Name: setup uk_sfovfatbat6jrwfjg4fh733gn; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT uk_sfovfatbat6jrwfjg4fh733gn UNIQUE (fuel_strategy_id);


--
-- TOC entry 4785 (class 2606 OID 16538)
-- Name: validate_setup uk_yiskkerh2xfjcayokr3fc7h4; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT uk_yiskkerh2xfjcayokr3fc7h4 UNIQUE (validate_mechanical_grip_id);


--
-- TOC entry 4763 (class 2606 OID 16461)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 4765 (class 2606 OID 16468)
-- Name: validate_aero validate_aero_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_aero
    ADD CONSTRAINT validate_aero_pkey PRIMARY KEY (id);


--
-- TOC entry 4767 (class 2606 OID 16475)
-- Name: validate_dampers validate_dampers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_dampers
    ADD CONSTRAINT validate_dampers_pkey PRIMARY KEY (id);


--
-- TOC entry 4769 (class 2606 OID 16482)
-- Name: validate_electronics validate_electronics_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_electronics
    ADD CONSTRAINT validate_electronics_pkey PRIMARY KEY (id);


--
-- TOC entry 4771 (class 2606 OID 16490)
-- Name: validate_fuel_strategy validate_fuel_strategy_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_fuel_strategy
    ADD CONSTRAINT validate_fuel_strategy_pkey PRIMARY KEY (id);


--
-- TOC entry 4773 (class 2606 OID 16497)
-- Name: validate_mechanical_grip validate_mechanical_grip_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_mechanical_grip
    ADD CONSTRAINT validate_mechanical_grip_pkey PRIMARY KEY (id);


--
-- TOC entry 4787 (class 2606 OID 16505)
-- Name: validate_setup validate_setup_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT validate_setup_pkey PRIMARY KEY (id);


--
-- TOC entry 4789 (class 2606 OID 16512)
-- Name: validate_tyres validate_tyres_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_tyres
    ADD CONSTRAINT validate_tyres_pkey PRIMARY KEY (id);


--
-- TOC entry 4797 (class 2606 OID 16586)
-- Name: validate_setup fk368d8hxhmu3jkyptklxi91dor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT fk368d8hxhmu3jkyptklxi91dor FOREIGN KEY (validate_electronics_id) REFERENCES public.validate_electronics(id);


--
-- TOC entry 4798 (class 2606 OID 16601)
-- Name: validate_setup fk3kgao5hwj8py5hgwi5cbk2xvk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT fk3kgao5hwj8py5hgwi5cbk2xvk FOREIGN KEY (validate_tyres_id) REFERENCES public.validate_tyres(id);


--
-- TOC entry 4799 (class 2606 OID 16576)
-- Name: validate_setup fk6ck9q4ciwx8amnh7fvjklhqh8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT fk6ck9q4ciwx8amnh7fvjklhqh8 FOREIGN KEY (validate_aero_id) REFERENCES public.validate_aero(id);


--
-- TOC entry 4800 (class 2606 OID 16581)
-- Name: validate_setup fk712lngviykjx08c9udlvthp41; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT fk712lngviykjx08c9udlvthp41 FOREIGN KEY (validate_dampers_id) REFERENCES public.validate_dampers(id);


--
-- TOC entry 4790 (class 2606 OID 16541)
-- Name: setup fkb4qurssam4v0a24f8fvudbt1g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT fkb4qurssam4v0a24f8fvudbt1g FOREIGN KEY (aero_id) REFERENCES public.setup_aero(id);


--
-- TOC entry 4791 (class 2606 OID 16561)
-- Name: setup fkgowc0la6v4oggmwodg5d8dvdx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT fkgowc0la6v4oggmwodg5d8dvdx FOREIGN KEY (mechanical_grip_id) REFERENCES public.setup_mechanical_grip(id);


--
-- TOC entry 4792 (class 2606 OID 16556)
-- Name: setup fkguflp1qghxiu8xkolmn1diu2c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT fkguflp1qghxiu8xkolmn1diu2c FOREIGN KEY (fuel_strategy_id) REFERENCES public.setup_fuel_strategy(id);


--
-- TOC entry 4801 (class 2606 OID 16596)
-- Name: validate_setup fkhghw6aly2745g35oi2xqjh7gm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT fkhghw6aly2745g35oi2xqjh7gm FOREIGN KEY (validate_mechanical_grip_id) REFERENCES public.validate_mechanical_grip(id);


--
-- TOC entry 4793 (class 2606 OID 16566)
-- Name: setup fkjwwepomc3tw206g8ff15wjq7g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT fkjwwepomc3tw206g8ff15wjq7g FOREIGN KEY (tyres_id) REFERENCES public.setup_tyres(id);


--
-- TOC entry 4794 (class 2606 OID 16546)
-- Name: setup fkmgr8li9ptse1nvwakjubato2j; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT fkmgr8li9ptse1nvwakjubato2j FOREIGN KEY (dampers_id) REFERENCES public.setup_dampers(id);


--
-- TOC entry 4802 (class 2606 OID 16591)
-- Name: validate_setup fkrh6k0blkuis67thx6ajp6kpe4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.validate_setup
    ADD CONSTRAINT fkrh6k0blkuis67thx6ajp6kpe4 FOREIGN KEY (validate_fuel_strategy_id) REFERENCES public.validate_fuel_strategy(id);


--
-- TOC entry 4795 (class 2606 OID 16551)
-- Name: setup fksh4rfjcbc303lhtq90ll2tdpq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT fksh4rfjcbc303lhtq90ll2tdpq FOREIGN KEY (electronics_id) REFERENCES public.setup_electronics(id);


--
-- TOC entry 4796 (class 2606 OID 16571)
-- Name: setup fkt7y23ji1r2n6d75vo32sicu5k; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setup
    ADD CONSTRAINT fkt7y23ji1r2n6d75vo32sicu5k FOREIGN KEY (user_id) REFERENCES public.users(id);


-- Completed on 2023-10-27 11:00:45

--
-- PostgreSQL database dump complete
--

