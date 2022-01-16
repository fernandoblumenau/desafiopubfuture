INSERT INTO public.conta
(idconta, tipoconta, instfinanceira, vlrsaldo)
VALUES(10, 'carteira', 'home', 100);

INSERT INTO public.conta
(idconta, tipoconta, instfinanceira, vlrsaldo)
VALUES(20, 'conta corrente', 'Itau', 200);

INSERT INTO public.conta
(idconta, tipoconta, instfinanceira, vlrsaldo)
VALUES(30, 'poupança', 'Itau', 300);

INSERT INTO public.despesa
(idconta, datapagto, datapagtoesperado, tipodespesa, vlrdespesa)
VALUES(10, '2022-01-01', '2022-02-02', 'alimentação', 50);

INSERT INTO public.despesa
(idconta, datapagto, datapagtoesperado, tipodespesa, vlrdespesa)
VALUES(20, '2022-02-02', '2022-02-03', 'educação', 40);

INSERT INTO public.despesa
(idconta, datapagto, datapagtoesperado, tipodespesa, vlrdespesa)
VALUES(30, '2022-03-02', '2022-03-04', 'lazer', 30);

INSERT INTO public.receita
(idconta, tiporeceita, datarecebimento, datarecebesperado, descreceita, vlrreceita)
VALUES(10, 'salário', '2022-01-01', '2022-01-02', 'Salario Normal', 1000);

INSERT INTO public.receita
(idconta, tiporeceita, datarecebimento, datarecebesperado, descreceita, vlrreceita)
VALUES(20, 'presente', '2022-02-01', '2022-02-02', 'Bonus', 500);

INSERT INTO public.receita
(idconta, tiporeceita, datarecebimento, datarecebesperado, descreceita, vlrreceita)
VALUES(30, 'prêmio', '2022-03-01', '2022-03-02', 'vendas atingidas', 300);


