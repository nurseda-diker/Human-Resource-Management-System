-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public.activation_codes
(
    id integer NOT NULL,
    is_confirmed boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.activation_codes_employers
(
    employer_id integer NOT NULL,
    activiation_id integer NOT NULL,
    PRIMARY KEY (activiation_id)
);

CREATE TABLE public."activation_codes_jobSeekers"
(
    activiation_id integer NOT NULL,
    jobseeker_id integer NOT NULL,
    PRIMARY KEY (activiation_id)
);

CREATE TABLE public.employers
(
    company_name character varying(50)[] NOT NULL,
    web_site character varying(50)[] NOT NULL,
    phone_number character varying(15)[] NOT NULL,
    id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.employers_activation_employees
(
    activiation_id integer NOT NULL,
    employer_id integer NOT NULL,
    confirmed_employee_id integer NOT NULL,
    is_confirmed boolean NOT NULL,
    PRIMARY KEY (activiation_id)
);

CREATE TABLE public."jobSeekers"
(
    first_name character varying(50)[] NOT NULL,
    last_name character varying(50)[] NOT NULL,
    nationality_id character(11) NOT NULL,
    date_of_birth smallint NOT NULL,
    id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_position
(
    position_name character varying(50)[] NOT NULL,
    id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public."systemEmployees"
(
    first_name character varying(50)[] NOT NULL,
    last_name character varying(50)[] NOT NULL,
    id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.users
(
    email character varying(50)[] NOT NULL,
    id integer NOT NULL,
    password character varying(50)[] NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.activation_codes_employers
    ADD FOREIGN KEY (activiation_id)
    REFERENCES public.activation_codes (id)
    NOT VALID;


ALTER TABLE public.activation_codes_employers
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (id)
    NOT VALID;


ALTER TABLE public."activation_codes_jobSeekers"
    ADD FOREIGN KEY (activiation_id)
    REFERENCES public.activation_codes (id)
    NOT VALID;


ALTER TABLE public."activation_codes_jobSeekers"
    ADD FOREIGN KEY (jobseeker_id)
    REFERENCES public."jobSeekers" (id)
    NOT VALID;


ALTER TABLE public.employers
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.employers_activation_employees
    ADD FOREIGN KEY (activiation_id)
    REFERENCES public.activation_codes (id)
    NOT VALID;


ALTER TABLE public.employers_activation_employees
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (id)
    NOT VALID;


ALTER TABLE public.employers_activation_employees
    ADD FOREIGN KEY (confirmed_employee_id)
    REFERENCES public."systemEmployees" (id)
    NOT VALID;


ALTER TABLE public."jobSeekers"
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public."systemEmployees"
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;

END;