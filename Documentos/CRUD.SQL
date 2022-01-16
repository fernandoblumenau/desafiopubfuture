-- public.conta definition
-- public.despesa definition
-- public.receita definition


-- DROP TABLE public.conta;

-- DROP TABLE public.despesa;


CREATE TABLE public.conta (
	idconta int4 NOT NULL,
	tipoconta varchar(20) NOT NULL,
	instfinanceira varchar(20) NOT NULL,
	vlrsaldo numeric(8, 2) NOT NULL,
	CONSTRAINT conta_pkey PRIMARY KEY (idconta)
);


CREATE TABLE public.despesa (
	idconta int4 NOT NULL,
	datapagto date NOT NULL,
	datapagtoesperado date NOT NULL,
	tipodespesa varchar(30) NOT NULL,
	vlrdespesa numeric(8, 2) NOT NULL,
	CONSTRAINT despesa_pkey PRIMARY KEY (idconta, datapagto, tipodespesa)
);


CREATE TABLE public.receita (
	idconta int4 NOT NULL,
	tiporeceita varchar(30) NOT NULL,
	datarecebimento date NOT NULL,
	datarecebesperado date NOT NULL,
	descreceita varchar(30) NOT NULL,
	vlrreceita numeric(8, 2) NULL,
	CONSTRAINT receita_pkey PRIMARY KEY (idconta, tiporeceita, datarecebimento)
);
