
	--Grupos de produtos
insert into tb_grupo_produto(id,data_cadastro,ativo,versao, descricao) 
values (1,current_date,true,0,'Ativo Imobilizado'),
(2,current_date,true,0,'Embalagem'),
(3,current_date,true,0,'Garrafa'),
(4,current_date,true,0,'Matéria-Prima'),(5,current_date,true,0,'Material de Uso e Consumo'),
(6,current_date,true,0,'Mercadoria para revenda'),
(7,current_date,true,0,'Outras'),(8,current_date,true,0,'Outros insumos'),(9,current_date,true,0,'Produto Acabado'),
(10,current_date,true,0,'Produto em Processo'),
(11,current_date,true,0,'Produto Intermediário'),
(12,current_date,true,0,'Serviços'),
(13,current_date,true,0,'Subprodutos'),
(14,current_date,true,0,'MANTIMENTOS EM CONSERVA'),
(15,current_date,true,0,'FEIRA E PERECÍVEIS'),
(16,current_date,true,0,'PRODUTOS NÃO PERECÍVEIS'),
(17,current_date,true,0,'Limpeza'),
(18,current_date,true,0,'BEBIDAS EXTRAS');

--Origem da Mercadoria
insert into tb_origem_mercadoria(id,data_cadastro,ativo,versao, descricao,codigo)
values (1,current_date,true,0,'Nacional, exceto as indicadas nos códigos 3,4,5 e 8',0),
(2,current_date,true,0,'Estrangeira - Importação direta, exceto a indicada no código 6',1),
(3,current_date,true,0,'Estrangeira Adquirida no mercado interno, exceto a indicada no código 7',2),
(4,current_date,true,0,'Nacional, mercadoria ou bem com conteúdo de importação superior a 40% e inferior ou igual a 70%',3),
(5,current_date,true,0,'Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam as legislações citadas no Ajuste',4),
(6,current_date,true,0,'Nacional, mercadoria ou bem de conteúdo de importação inferior ou igual a 40%',5),
(7,current_date,true,0,'Estrangeira - importação direta, sem similar nacional constante, contante em lista da CAMEX e gás natural',6),
(8,current_date,true,0,'Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista da CAMEX e gás natural',7),
(9,current_date,true,0,'Nacional, mercadoria ou bem de conteúdo de importação superior a 70%',8);

--SELECT pg_catalog.setval('origem_mercadoria_sequence', 10, true);

--Regime Tributário
insert into tb_regime_tributario(id,data_cadastro,ativo,versao, descricao,codigo)
values (1,current_date,true,0,'Simples Nacional',0),
(2,current_date,true,0,'Tributação Normal',1);
--SELECT pg_catalog.setval('regime_tributario_sequence', 3, true);

--Situação Tributária icms
insert into tb_situacao_tributaria_simples_nacional_icms(id,data_cadastro,ativo,versao, descricao,codigo)
values 
(1,current_date,true,0,'Tributada com permissão de crédito',101),
(2,current_date,true,0,'Tributada sem permissão de crédito',102),
(3,current_date,true,0,'Isenção do ICMS para faixa de receita bruta',103),
(4,current_date,true,0,'Tributada com permissão de crédito e com cobrança do ICMS por ST',201),
(5,current_date,true,0,'Tributada sem permissão de crédito e com cobrança do ICMS por ST',202),
(6,current_date,true,0,'Isenção do ICMS para faixa de receita bruta e com cobrança do ICMS por ST',203),
(7,current_date,true,0,'imune',300),
(8,current_date,true,0,'Não Tributada',400),
(9,current_date,true,0,'ICMS cobrado anteriormente por ST ou por antecipação',500),
(10,current_date,true,0,'Outros',900);
--SELECT pg_catalog.setval('SITUACAO_TRIBUTARIA_SIMPLES_NACIONAL_ICMS_SEQUENCE', 13, true);

--Situação Tributária icms
insert into tb_situacao_tributaria_icms(id,data_cadastro,ativo,versao, descricao,codigo)
values 
(1,current_date,true,0,'Tributada Integralmente',00),
(2,current_date,true,0,'Tributada com cobrança do ICMS por ST',10),
(3,current_date,true,0,'Tributada com cobrança do ICMS por ST(com partilha do ICMS entre a UF de origem e a UF de destino ou UF definida na legislação',10),
(4,current_date,true,0,'Com redução da base de cálculo',20),
(5,current_date,true,0,'Isenta ou não tributada e com cobrança do ICMS por ST',30),
(6,current_date,true,0,'Isenta',40),
(7,current_date,true,0,'Não tributada',41),
(8,current_date,true,0,'Não tributada(ICMSST devido para a UF de destino, nas operações interestaduais que tiveram retenção antecipada do ICMS por ST na UF do remetente',41),
(9,current_date,true,0,'Suspensão',50),
(10,current_date,true,0,'Diferimento',51),
(11,current_date,true,0,'Cobrado anteriormente por ST',60),
(12,current_date,true,0,'Com redução da base de Cálculo e cobrança do ICMS por ST',70),
(13,current_date,true,0,'Outras (com partilha do ICMS entre a UF de origem e a UF de destino ou a UF definida na legislação',90),
(14,current_date,true,0,'Outras',90);

--SELECT pg_catalog.setval('situacao_tributaria_icms_sequence', 15, true);

--modalidade banco central
insert into tb_modalidade_banco_central_icms(id,data_cadastro,ativo,versao, descricao)
values 
(1,current_date,true,0,'Margem Valor Agregado'),
(2,current_date,true,0,'Pauta (valor)'),
(3,current_date,true,0,'Preço Tabela Max. (valor)'),
(4,current_date,true,0,'Valor da Operação');
--SELECT pg_catalog.setval('modalidade_bc_icms_sequence', 15, true);

--modalidade banco central ICMS ST
insert into tb_modalidade_banco_central_icms_st(id,data_cadastro,ativo,versao, descricao)
values 
(1,current_date,true,0,'Preço Tabelado ou Máximo Sugerido'),
(2,current_date,true,0,'Lista Negativa (valor)'),
(3,current_date,true,0,'Lista Positiva (valor)'),
(4,current_date,true,0,'Lista Neutra (valor)'),
(5,current_date,true,0,'Margem Valor Agregado (%)'),
(6,current_date,true,0,'Pauta (valor)');
--SELECT pg_catalog.setval('modalidade_bc_icms_st_sequence', 10, true);


--Situação Tributária IPI
insert into tb_situacao_tributaria_ipi(id,data_cadastro,ativo,versao, descricao,codigo)
values 
(1,current_date,true,0,'Entrada com recuperação de crédito','IPI 00'),
(2,current_date,true,0,'Entrada tributada com alíquota zero','IPI 01'),
(3,current_date,true,0,'Enrada Isenta','IPI 02'),
(4,current_date,true,0,'Entrada não-tributada','IPI 03'),
(5,current_date,true,0,'Entrada imune','IPI 04'),
(6,current_date,true,0,'Entrada com suspensão','IPI 05'),
(7,current_date,true,0,'Outras entradas','IPI 49'),
(8,current_date,true,0,'Saída tributada','IPI 50'),
(9,current_date,true,0,'Saída tributada com alíquota zero','IPI 51'),
(10,current_date,true,0,'Saída isenta','IPI 52'),
(11,current_date,true,0,'Saída não-tributada','IPI 53'),
(12,current_date,true,0,'Saída imune','IPI 54'),
(13,current_date,true,0,'Saída com suspensão','IPI 55'),
(14,current_date,true,0,'Outras Saídas','IPI 99');
--SELECT pg_catalog.setval('situacao_tributaria_ipi_sequence', 15, true);

--Situação Tributária PIS
insert into tb_situacao_tributaria_pis(id,data_cadastro,ativo,versao, descricao,codigo)
values 
(1,current_date,true,0,'Operação Tributável - Base de Cálculo  = Valor da Operação Alíquota Normal (Comulativo/Não Comulativo','PIS 01'),
(2,current_date,true,0,'Operação Tributável - Base de Cálculo  = Valor da Operação (Alíquota Difereciada) ','PIS 02'),
(3,current_date,true,0,'Operação Tributável - Base de Cálculo = Quantidade Vendida x Alíquota por Unidade de Produto','PIS 03'),
(4,current_date,true,0,'Operação Tributável - Tributação Monofásica - (Alíquota Zero)','PIS 04'),
(5,current_date,true,0,'Operação Tributável - (ST)','PIS 05'),
(6,current_date,true,0,'Operação Tributável com Alíquota Zero','PIS 06'),
(7,current_date,true,0,'Operação Isenta de Contribuição','PIS 07'),
(8,current_date,true,0,'Operação sem Incidência da Contribuição','PIS 08'),
(9,current_date,true,0,'Operação com Suspensão da Contribuição','PIS 09'),
(10,current_date,true,0,'Outras Operações de Saída','PIS 49'),
(11,current_date,true,0,'Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno','PIS 50'),
(12,current_date,true,0,'Operação com Direito a Crédito - Vinculada Exclusivamente a Receita não Tributada no Mercado Interno','PIS 51'),
(13,current_date,true,0,'Operação com Direito a Crédito - Vinculada Exclusivamente a Receita de Exportação','PIS 52'),
(14,current_date,true,0,'Operação com Direito a Crédito - Vinculadas a Receitas Tributadas e Não-Tributadas no Mercado Interno','PIS 53'),
(15,current_date,true,0,'Operação com Direito a Crédito - Vinculadas a Receitas Tributadas no Mercado Interno e de Exportação','PIS 54'),
(16,current_date,true,0,'Operação com Direito a Crédito - Vinculadas a Receitas Não-Tributadas no Mercado Interno e de Exportação','PIS 55'),
(17,current_date,true,0,'Operação com Direito a Crédito - Vinculadas a Receitas Tributadas e Não-Tributadas no Mercado Interno e de Exportação','PIS 56'),
(18,current_date,true,0,'Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Tributada no Mercado Interno','PIS 60'),
(19,current_date,true,0,'Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Não-Tributada no Mercado Interno','PIS 61'),
(20,current_date,true,0,'Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita de Exportação','PIS 62'),
(21,current_date,true,0,'Crédito Presumido - Operação de Aquisição Vinculada a Receita Tributadas e Não-Tributadas no Mercado Interno','PIS 63'),
(22,current_date,true,0,'Crédito Presumido - Operação de Aquisição Vinculada a Receita Tributadas no Mercado Interno e de Exportação','PIS 64'),
(23,current_date,true,0,'Crédito Presumido - Operação de Aquisição Vinculada a Receita Não-Tributadas no Mercado Interno e de Exportação','PIS 65'),
(24,current_date,true,0,'Crédito Presumido - Operação de Aquisição Vinculada a Receita Tributada e Não-Tributadas no Mercado Interno e de Exportação','PIS 66'),
(25,current_date,true,0,'Crédito Presumido - Outras Operações','PIS 67'),
(26,current_date,true,0,'Operação de Aquisição sem Direito a Crédito','PIS 70'),
(27,current_date,true,0,'Operação de Aquisição com Isenção','PIS 71'),
(28,current_date,true,0,'Operação de Aquisição com Suspensão','PIS 72'),
(29,current_date,true,0,'Operação de Aquisição a Alíquota Zero','PIS 73'),
(30,current_date,true,0,'Operação de Aquisição sem Incidência da Contribuição','PIS 74'),
(31,current_date,true,0,'Operação de Aquisição por Substituição Tributária','PIS 75'),
(32,current_date,true,0,'Outras Operações de Entrada','PIS 98'),
(33,current_date,true,0,'Outras Operações','PIS 99');

--SELECT pg_catalog.setval('situacao_tributaria_pis_sequence', 35, true);

--Confins 
insert into tb_cofins(id,data_cadastro,ativo,versao, descricao,codigo)
values 
(1,current_date,true,0,'Operação Tributável - Base de Cálculo  = Valor da Operação Alíquota Normal (Comulativo/Não Comulativo','COFINS 01'),
(2,current_date,true,0,'Operação Tributável - Base de Cálculo  = Valor da Operação (Alíquota Difereciada) ','COFINS 02'),
(3,current_date,true,0,'Operação Tributável - Base de Cálculo = Quantidade Vendida x Alíquota por Unidade de Produto','COFINS 03'),
(4,current_date,true,0,'Operação Tributável - Tributação Monofásica - (Alíquota Zero)','COFINS 04'),
(5,current_date,true,0,'Operação Tributável - (ST)','COFINS 05'),
(6,current_date,true,0,'Operação Tributável com Alíquota Zero','COFINS 06'),
(7,current_date,true,0,'Operação Isenta de Contribuição','COFINS 07'),
(8,current_date,true,0,'Operação sem Incidência da Contribuição','COFINS 08'),
(9,current_date,true,0,'Operação com Suspensão da Contribuição','COFINS 09'),
(10,current_date,true,0,'Outras Operações de Saída','COFINS 49'),
(11,current_date,true,0,'Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno','COFINS 50'),
(12,current_date,true,0,'Operação com Direito a Crédito - Vinculada Exclusivamente a Receita não Tributada no Mercado Interno','COFINS 51'),
(13,current_date,true,0,'Operação com Direito a Crédito - Vinculada Exclusivamente a Receita de Exportação','COFINS 52'),
(14,current_date,true,0,'Operação com Direito a Crédito - Vinculadas a Receitas Tributadas e Não-Tributadas no Mercado Interno','COFINS 53'),
(15,current_date,true,0,'Operação com Direito a Crédito - Vinculadas a Receitas Tributadas no Mercado Interno e de Exportação','COFINS 54'),
(16,current_date,true,0,'Operação com Direito a Crédito - Vinculadas a Receitas Não-Tributadas no Mercado Interno e de Exportação','COFINS 55'),
(17,current_date,true,0,'Operação com Direito a Crédito - Vinculadas a Receitas Tributadas e Não-Tributadas no Mercado Interno, e de Exportação','COFINS 56'),
(18,current_date,true,0,'Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Tributada no Mercado Interno','COFINS 60'),
(19,current_date,true,0,'Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Não-Tributada no Mercado Interno','COFINS 61'),
(20,current_date,true,0,'Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita de Exportação','COFINS 62'),
(21,current_date,true,0,'Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno','COFINS 63'),
(22,current_date,true,0,'Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas no Mercado Interno e de Exportação','COFINS 64'),
(23,current_date,true,0,'Crédito Presumido - Operação de Aquisição Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação','COFINS 65'),
(24,current_date,true,0,'Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributada e Não-Tributadas no Mercado Interno, e de Exportação','COFINS 66'),
(25,current_date,true,0,'Crédito Presumido - Outras Operações','COFINS 67'),
(26,current_date,true,0,'Operação de Aquisição sem Direito a Crédito','COFINS 70'),
(27,current_date,true,0,'Operação de Aquisição com Isenção','COFINS 71'),
(28,current_date,true,0,'Operação de Aquisição com Suspensão','COFINS 72'),
(29,current_date,true,0,'Operação de Aquisição a Alíquota Zero','COFINS 73'),
(30,current_date,true,0,'Operação de Aquisição sem Incidência da Contribuição','COFINS 74'),
(31,current_date,true,0,'Operação de Aquisição por Substituição Tributária','COFINS 75'),
(32,current_date,true,0,'Outras Operações de Entrada','COFINS 98'),
(33,current_date,true,0,'Outras Operações','COFINS	 99');

--SELECT pg_catalog.setval('cofins_sequence', 35, true);



--Tipo de Mercadoria Fiscal
insert into tb_tipo_produto_fiscal(id,data_cadastro,ativo,versao, descricao)
values (1,current_date,true,0,'Mercadoria para revenda'),
(2,current_date,true,0,'Matéria-Prima'),
(3,current_date,true,0,'Embalagem'),
(4,current_date,true,0,'Produto em Processo'),
(5,current_date,true,0,'Produto Acabado'),
(6,current_date,true,0,'Subproduto'),
(7,current_date,true,0,'Produto Intermediário'),
(8,current_date,true,0,'Material de Uso e Consumo'),
(9,current_date,true,0,'Ativo Imobilizado'),
(10,current_date,true,0,'Serviços'),
(11,current_date,true,0,'Outros insumos'),
(12,current_date,true,0,'Outras');

--SELECT pg_catalog.setval('tipo_produto_fiscal_sequence', 12, true);

--MOTIVO DESONERAÇÃO	
insert into tb_motivo_desoneracao(id,data_cadastro,ativo,versao, descricao)
values 
(1,current_date,true,0,'Táxi'),
(2,current_date,true,0,'Produtor Agropecuário'),
(3,current_date,true,0,'Frotista/Locadora'),
(4,current_date,true,0,'Diplomático/Consular'),
(5,current_date,true,0,'Utilit. e Motoc. da Amazônia ...'),
(6,current_date,true,0,'SUFRAMA'),
(7,current_date,true,0,'Venda de Orgãos Públicos'),
(8,current_date,true,0,'Outros'),
(9,current_date,true,0,'Deficiente Condutor'),
(10,current_date,true,0,'Deficiente Não Condutor'),
(11,current_date,true,0,'Orgão de fomento e desenvol.');

--SELECT pg_catalog.setval('motivo_desoneracao_sequence', 12, true);

--LOCAL ESTOQUE	
insert into tb_local_estoque(id,data_cadastro,ativo,versao, descricao)
values 
(1,current_date,true,0,'Cozinha Indústrial');
--SELECT pg_catalog.setval('LOCAL_ESTOQUE_SEQUENCE', 10, true);

--SITUACAO PEDIDO
INSERT INTO tb_situacao_pedido (id, ativo, data_alteracao, data_cadastro, data_exclusao, versao, descricao) VALUES (1, true, NULL, '2015-12-01 09:22:38.014', NULL, 0, 'A Fabricar');
INSERT INTO tb_situacao_pedido (id, ativo, data_alteracao, data_cadastro, data_exclusao, versao, descricao) VALUES (2, true, NULL, '2015-12-01 09:22:38.014', NULL, 0, 'Em Produção');
INSERT INTO tb_situacao_pedido (id, ativo, data_alteracao, data_cadastro, data_exclusao, versao, descricao ) VALUES (3, true, NULL, '2015-12-01 09:22:38.014', NULL, 0, 'A Entregar');
INSERT INTO tb_situacao_pedido (id, ativo, data_alteracao, data_cadastro, data_exclusao, versao, descricao ) VALUES (4, true, NULL, '2015-12-01 09:22:38.014', NULL, 0, 'Na Entrega');
INSERT INTO tb_situacao_pedido (id, ativo, data_alteracao, data_cadastro, data_exclusao, versao, descricao ) VALUES (5, true, NULL, '2015-12-01 09:22:38.014', NULL, 0, 'Entregue');
INSERT INTO tb_situacao_pedido (id, ativo, data_alteracao, data_cadastro, data_exclusao, versao, descricao ) VALUES (6, true, NULL, '2015-12-01 09:22:38.014', NULL, 0, 'Cancelar');




update tb_cargo set ativo=true and versao=0 and data_cadastro=current_date;
update tb_categoria_receita set ativo=true and versao=0 and data_cadastro=current_date;
update tb_categoria_produto set ativo=true and versao=0 and data_cadastro=current_date;
update tb_colaborador set ativo=true and versao=0 and data_cadastro=current_date;
update tb_cheque set ativo=true and versao=0 and data_cadastro=current_date;
update tb_cliente set ativo=true and versao=0 and data_cadastro=current_date;
update tb_codigo_apuracao_efd set ativo=true and versao=0 and data_cadastro=current_date;
update tb_codigo_gps set ativo=true and versao=0 and data_cadastro=current_date;
update tb_cofins set ativo=true and versao=0 and data_cadastro=current_date;
update tb_cfop set ativo=true and versao=0 and data_cadastro=current_date;
update tb_cnae set ativo=true and versao=0 and data_cadastro=current_date;
update tb_compra_fornecedor_cotacao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_compra_pedido_detalhe set ativo=true and versao=0 and data_cadastro=current_date;
update tb_compra_requisicao_detalhe set ativo=true and versao=0 and data_cadastro=current_date;
update tb_condicoes_pagamento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_compra_requisicao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_compra_pedido set ativo=true and versao=0 and data_cadastro=current_date;
update tb_compra_tipo_requisicao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_compra_tipo_pedido set ativo=true and versao=0 and data_cadastro=current_date;
update tb_compra_req_cotacao_detalhe set ativo=true and versao=0 and data_cadastro=current_date;
update tb_contabil_historico set ativo=true and versao=0 and data_cadastro=current_date;
update tb_contabil_lote set ativo=true and versao=0 and data_cadastro=current_date;
update tb_contato set ativo=true and versao=0 and data_cadastro=current_date;
update tb_contador set ativo=true and versao=0 and data_cadastro=current_date;
update tb_contrib_sind_patronal_cab set ativo=true and versao=0 and data_cadastro=current_date;
update tb_contrib_sind_patronal_det set ativo=true and versao=0 and data_cadastro=current_date;
update tb_csosn_b set ativo=true and versao=0 and data_cadastro=current_date;
update tb_cst_cofins set ativo=true and versao=0 and data_cadastro=current_date;
update tb_cst_icms_a set ativo=true and versao=0 and data_cadastro=current_date;
update tb_cst_icms_b set ativo=true and versao=0 and data_cadastro=current_date;
update tb_cst_ipi set ativo=true and versao=0 and data_cadastro=current_date;
update tb_cst_pis set ativo=true and versao=0 and data_cadastro=current_date;
update tb_credito set ativo=true and versao=0 and data_cadastro=current_date;
update tb_csosn_a set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_caixa set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_fechamento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_impressora set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_movimento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_nota_fiscal_cabecalho set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_nota_fiscal_detalhe set ativo=true and versao=0 and data_cadastro=current_date;
update tb_dav_detalhe_alteracao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_aliquotas set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_documentos_emitidos set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_r07 set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_recebimento_nao_fiscal set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_sangria set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_sintegra_60a set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_sintegra_60m set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_suprimento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_r06 set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_r03 set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_venda_detalhe set ativo=true and versao=0 and data_cadastro=current_date;
update tb_efd_tabela_4310 set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_venda_cabecalho set ativo=true and versao=0 and data_cadastro=current_date;
update tb_efd_tabela_4313 set ativo=true and versao=0 and data_cadastro=current_date;
update tb_efd_tabela_4314 set ativo=true and versao=0 and data_cadastro=current_date;
update tb_efd_tabela_4315 set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_tipo_pagamento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_total_tipo_pagamento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_efd_tabela_437 set ativo=true and versao=0 and data_cadastro=current_date;
update tb_efd_tabela_439 set ativo=true and versao=0 and data_cadastro=current_date;
update tb_empresa_cnae set ativo=true and versao=0 and data_cadastro=current_date;
update tb_efd_tabela_4316 set ativo=true and versao=0 and data_cadastro=current_date;
update tb_empresa_pessoa set ativo=true and versao=0 and data_cadastro=current_date;
update tb_empresa_contato set ativo=true and versao=0 and data_cadastro=current_date;
update tb_empresa_endereco set ativo=true and versao=0 and data_cadastro=current_date;
update tb_efd_tabela_436 set ativo=true and versao=0 and data_cadastro=current_date;
update tb_empresa_produto set ativo=true and versao=0 and data_cadastro=current_date;
update tb_endereco set ativo=true and versao=0 and data_cadastro=current_date;
update tb_empresa_transporte set ativo=true and versao=0 and data_cadastro=current_date;
update tb_erro_sistema set ativo=true and versao=0 and data_cadastro=current_date;
update tb_estado_civil set ativo=true and versao=0 and data_cadastro=current_date;
update tb_estoque_saida set ativo=true and versao=0 and data_cadastro=current_date;
update tb_estoque set ativo=true and versao=0 and data_cadastro=current_date;
update tb_estoque_lancamento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_configuracao_boleto set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_cheque_emitido set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_documento_origem set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_extrato_conta_banco set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_fechamento_caixa_banco set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_cheque_recebido set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ficha_tecnica set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_cobranca set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_tipo_recebimento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_lancamento_receber set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_lancamento_pagar set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_status_parcela set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_tipo_pagamento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_parcela_pagar set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_parcela_pagamento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_parcela_recebimento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fiscal_estadual_regime set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fiscal_estadual_porte set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fiscal_nota_fiscal_entrada set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fiscal_livro set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fiscal_municipal_regime set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fiscal_apuracao_icms set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fiscal_nota_fiscal_saida set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fiscal_termo set ativo=true and versao=0 and data_cadastro=current_date;
update tb_forma_pagamento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_icms set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fornecedor set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ipi set ativo=true and versao=0 and data_cadastro=current_date;
update tb_grupo_fiscal set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fpas set ativo=true and versao=0 and data_cadastro=current_date;
update tb_funcao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_inss set ativo=true and versao=0 and data_cadastro=current_date;
update tb_grupo_receita set ativo=true and versao=0 and data_cadastro=current_date;
update tb_local_estoque set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_cana set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_acesso_xml set ativo=true and versao=0 and data_cadastro=current_date;
update tb_motivo_desoneracao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_modalidade_banco_central_icms_st set ativo=true and versao=0 and data_cadastro=current_date;
update tb_log_atividades set ativo=true and versao=0 and data_cadastro=current_date;
update tb_moeda set ativo=true and versao=0 and data_cadastro=current_date;
update tb_modalidade_banco_central_icms set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ncm set ativo=true and versao=0 and data_cadastro=current_date;
update tb_municipio set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_cupom_fiscal_referenciado set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_destinatario set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_det_especifico_armamento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_det_especifico_veiculo set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_declaracao_importacao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_configuracao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_det_especifico_combustivel set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_cte_referenciado set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_det_especifico_medicamento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_detalhe_imposto_issqn set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_detalhe_imposto_pis set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_emitente set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_forma_pagamento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_detalhe_imposto_ii set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_detalhe_imposto_cofins set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_detalhe_imposto_icms set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_detalhe_imposto_ipi set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_duplicata set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_exportacao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_fatura set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_local_retirada set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_nf_referenciada set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_processo_referenciado set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_prod_rural_referenciada set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_transporte set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_local_entrega set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_numero set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_referenciada set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nota_fiscal_modelo set ativo=true and versao=0 and data_cadastro=current_date;
update tb_operadora_cartao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_orcamento_empresarial set ativo=true and versao=0 and data_cadastro=current_date;
update tb_operadora_plano_saude set ativo=true and versao=0 and data_cadastro=current_date;
update tb_orcamento_fluxo_caixa set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_transporte_volume_lacre set ativo=true and versao=0 and data_cadastro=current_date;
update tb_orcamento_fluxo_caixa_detalhe set ativo=true and versao=0 and data_cadastro=current_date;
update tb_parcelamento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_papel set ativo=true and versao=0 and data_cadastro=current_date;
update tb_pais set ativo=true and versao=0 and data_cadastro=current_date;
update tb_patrim_bem set ativo=true and versao=0 and data_cadastro=current_date;
update tb_orcamento_fluxo_caixa_periodo set ativo=true and versao=0 and data_cadastro=current_date;
update tb_orcamento_periodo set ativo=true and versao=0 and data_cadastro=current_date;
update tb_patrim_depreciacao_bem set ativo=true and versao=0 and data_cadastro=current_date;
update tb_patrim_tipo_aquisicao_bem set ativo=true and versao=0 and data_cadastro=current_date;
update tb_pedido set ativo=true and versao=0 and data_cadastro=current_date;
update tb_pedido_receita set ativo=true and versao=0 and data_cadastro=current_date;
update tb_patrim_indice_atualizacao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_patrim_taxa_depreciacao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_patrim_grupo_bem set ativo=true and versao=0 and data_cadastro=current_date;
update tb_patrim_documento_bem set ativo=true and versao=0 and data_cadastro=current_date;
update tb_patrim_tipo_movimentacao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_pessoa_endereco set ativo=true and versao=0 and data_cadastro=current_date;
update tb_pessoa_telefone set ativo=true and versao=0 and data_cadastro=current_date;
update tb_pessoa_alteracao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_pessoa_fisica set ativo=true and versao=0 and data_cadastro=current_date;
update tb_pessoa_juridica set ativo=true and versao=0 and data_cadastro=current_date;
update tb_pessoa_contato set ativo=true and versao=0 and data_cadastro=current_date;
update tb_plano_conta set ativo=true and versao=0 and data_cadastro=current_date;
update tb_regime_tributario set ativo=true and versao=0 and data_cadastro=current_date;
update tb_pre_venda_cabecalho set ativo=true and versao=0 and data_cadastro=current_date;
update tb_produto_unidade set ativo=true and versao=0 and data_cadastro=current_date;
update tb_receita set ativo=true and versao=0 and data_cadastro=current_date;
update tb_salario_minimo set ativo=true and versao=0 and data_cadastro=current_date;
update tb_plano_natureza_financeira set ativo=true and versao=0 and data_cadastro=current_date;
update tb_salario_familia set ativo=true and versao=0 and data_cadastro=current_date;
update tb_quadro_societario set ativo=true and versao=0 and data_cadastro=current_date;
update tb_sefip_codigo_recolhimento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_simples_nacional set ativo=true and versao=0 and data_cadastro=current_date;
update tb_sefip_codigo_movimentacao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_sefip_categoria_trabalho set ativo=true and versao=0 and data_cadastro=current_date;
update tb_situacao_colaborador set ativo=true and versao=0 and data_cadastro=current_date;
update tb_sindicato set ativo=true and versao=0 and data_cadastro=current_date;
update tb_seguradora set ativo=true and versao=0 and data_cadastro=current_date;
update tb_simples_nacional_cabecalho set ativo=true and versao=0 and data_cadastro=current_date;
update tb_situacao_tributaria_pis set ativo=true and versao=0 and data_cadastro=current_date;
update tb_situacao_tributaria_simples_nacional_icms set ativo=true and versao=0 and data_cadastro=current_date;
update tb_sub_categoria_produto set ativo=true and versao=0 and data_cadastro=current_date;
update tb_socio set ativo=true and versao=0 and data_cadastro=current_date;
update tb_situacao_tributaria_ipi set ativo=true and versao=0 and data_cadastro=current_date;
update tb_situacao_tributaria_icms set ativo=true and versao=0 and data_cadastro=current_date;
update tb_situacao_pedido set ativo=true and versao=0 and data_cadastro=current_date;
update tb_situacao_pagamento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tipo_desligamento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tipo_receita_dipi set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tipo_produto_fiscal set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tipo_colaborador set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tabela_preco_produto set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tipo_admissao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tipo_item_sped set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tipo_receita_dacon set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tipo_relacionamento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tribut_icms_uf set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tribut_icms_custom_cab set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tribut_icms_custom_det set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tribut_ipi_dipi set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tribut_iss set ativo=true and versao=0 and data_cadastro=current_date;
update tb_transportadora set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tribut_grupo_tributario set ativo=true and versao=0 and data_cadastro=current_date;
update tb_unidade set ativo=true and versao=0 and data_cadastro=current_date;
update tb_venda_romaneio_entrega set ativo=true and versao=0 and data_cadastro=current_date;
update tb_vendedor set ativo=true and versao=0 and data_cadastro=current_date;
update tb_uf set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tribut_pis_cod_apuracao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_venda_orcamento_cabecalho set ativo=true and versao=0 and data_cadastro=current_date;
update tb_banco set ativo=true and versao=0 and data_cadastro=current_date;
update tb_convenio set ativo=true and versao=0 and data_cadastro=current_date;
update tb_cbo set ativo=true and versao=0 and data_cadastro=current_date;
update tb_almoxarifado set ativo=true and versao=0 and data_cadastro=current_date;
update tb_conta_caixa set ativo=true and versao=0 and data_cadastro=current_date;
update tb_dav_detalhe set ativo=true and versao=0 and data_cadastro=current_date;
update tb_produto set ativo=true and versao=0 and data_cadastro=current_date;
update tb_pessoa set ativo=true and versao=0 and data_cadastro=current_date;
update tb_edav_cabecalho set ativo=true and versao=0 and data_cadastro=current_date;
update tb_aliquota_estadual_pe set ativo=true and versao=0 and data_cadastro=current_date;
update tb_estoque_produto set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_parcela_receber set ativo=true and versao=0 and data_cadastro=current_date;
update tb_empresa set ativo=true and versao=0 and data_cadastro=current_date;
update tb_usuario set ativo=true and versao=0 and data_cadastro=current_date;
update tb_cod_apuracao_receita_dacon set ativo=true and versao=0 and data_cadastro=current_date;
update tb_compra_cotacao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_agencia_banco set ativo=true and versao=0 and data_cadastro=current_date;
update tb_contabil_lancamento_cabecalho set ativo=true and versao=0 and data_cadastro=current_date;
update tb_compra_cotacao_detalhe set ativo=true and versao=0 and data_cadastro=current_date;
update tb_compra_cotacao_pedido_detalhe set ativo=true and versao=0 and data_cadastro=current_date;
update tb_ecf_r02 set ativo=true and versao=0 and data_cadastro=current_date;
update tb_contabil_lancamento_detalhe set ativo=true and versao=0 and data_cadastro=current_date;
update tb_empresa_transporte_itinerario set ativo=true and versao=0 and data_cadastro=current_date;
update tb_contabil_conta set ativo=true and versao=0 and data_cadastro=current_date;
update tb_efd_tabela_435 set ativo=true and versao=0 and data_cadastro=current_date;
update tb_empresa_telefone set ativo=true and versao=0 and data_cadastro=current_date;
update tb_feriados set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_cobranca_parcela_receber set ativo=true and versao=0 and data_cadastro=current_date;
update tb_atividade_for_cli set ativo=true and versao=0 and data_cadastro=current_date;
update tb_natureza_financeira set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_lcto_pagar_nt_financeira set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tribut_operacao_fiscal set ativo=true and versao=0 and data_cadastro=current_date;
update tb_grupo_produto set ativo=true and versao=0 and data_cadastro=current_date;
update tb_talonario_cheque set ativo=true and versao=0 and data_cadastro=current_date;
update tb_setor set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nivel_formacao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_plano_conta_ref_sped set ativo=true and versao=0 and data_cadastro=current_date;
update tb_situacao_for_cli set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fin_lcto_receber_nt_financeira set ativo=true and versao=0 and data_cadastro=current_date;
update tb_patrim_estado_conservacao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_financeiro_despesas set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fiscal_inscricoes_substitutas set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_detalhe set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_cana_fornecimento_diario set ativo=true and versao=0 and data_cadastro=current_date;
update tb_patrim_movimentacao_bem set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nota_fiscal_tipo set ativo=true and versao=0 and data_cadastro=current_date;
update tb_fiscal_parametro set ativo=true and versao=0 and data_cadastro=current_date;
update tb_inss_detalhe set ativo=true and versao=0 and data_cadastro=current_date;
update tb_pedido_pagamento set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_transporte_volume set ativo=true and versao=0 and data_cadastro=current_date;
update tb_orcamento_detalhe set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_importacao_detalhe set ativo=true and versao=0 and data_cadastro=current_date;
update tb_socio_dependente set ativo=true and versao=0 and data_cadastro=current_date;
update tb_origem_mercadoria set ativo=true and versao=0 and data_cadastro=current_date;
update tb_papel_funcao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_socio_participacao_societaria set ativo=true and versao=0 and data_cadastro=current_date;
update tb_patrim_apolice_seguro set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_cana_deducoes_safra set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_cabecalho set ativo=true and versao=0 and data_cadastro=current_date;
update tb_nfe_transporte_reboque set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tribut_configura_of_gt set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tabela_preco set ativo=true and versao=0 and data_cadastro=current_date;
update tb_pre_venda_detalhe set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tribut_cofins_cod_apuracao set ativo=true and versao=0 and data_cadastro=current_date;
update tb_produto_receita set ativo=true and versao=0 and data_cadastro=current_date;
update tb_simples_nacional_detalhe set ativo=true and versao=0 and data_cadastro=current_date;
update tb_venda_cabecalho set ativo=true and versao=0 and data_cadastro=current_date;
update tb_tributacao_normal set ativo=true and versao=0 and data_cadastro=current_date;


--aqui é para atualizar apenas os ativos das tabelas

update tb_cargo set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_categoria_receita set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_categoria_produto set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_colaborador set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_cheque set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_cliente set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_codigo_apuracao_efd set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_codigo_gps set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_cofins set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_cfop set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_cnae set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_compra_fornecedor_cotacao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_compra_pedido_detalhe set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_compra_requisicao_detalhe set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_condicoes_pagamento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_compra_requisicao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_compra_pedido set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_compra_tipo_requisicao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_compra_tipo_pedido set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_compra_req_cotacao_detalhe set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_contabil_historico set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_contabil_lote set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_contato set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_contador set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_contrib_sind_patronal_cab set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_contrib_sind_patronal_det set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_csosn_b set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_cst_cofins set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_cst_icms_a set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_cst_icms_b set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_cst_ipi set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_cst_pis set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_credito set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_csosn_a set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_caixa set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_fechamento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_impressora set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_movimento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_nota_fiscal_cabecalho set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_nota_fiscal_detalhe set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_dav_detalhe_alteracao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_aliquotas set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_documentos_emitidos set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_r07 set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_recebimento_nao_fiscal set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_sangria set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_sintegra_60a set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_sintegra_60m set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_suprimento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_r06 set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_r03 set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_venda_detalhe set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_efd_tabela_4310 set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_venda_cabecalho set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_efd_tabela_4313 set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_efd_tabela_4314 set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_efd_tabela_4315 set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_tipo_pagamento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_total_tipo_pagamento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_efd_tabela_437 set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_efd_tabela_439 set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_empresa_cnae set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_efd_tabela_4316 set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_empresa_pessoa set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_empresa_contato set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_empresa_endereco set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_efd_tabela_436 set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_empresa_produto set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_endereco set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_empresa_transporte set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_erro_sistema set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_estado_civil set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_estoque_saida set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_estoque set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_estoque_lancamento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_configuracao_boleto set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_cheque_emitido set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_documento_origem set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_extrato_conta_banco set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_fechamento_caixa_banco set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_cheque_recebido set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ficha_tecnica set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_cobranca set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_tipo_recebimento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_lancamento_receber set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_lancamento_pagar set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_status_parcela set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_tipo_pagamento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_parcela_pagar set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_parcela_pagamento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_parcela_recebimento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fiscal_estadual_regime set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fiscal_estadual_porte set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fiscal_nota_fiscal_entrada set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fiscal_livro set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fiscal_municipal_regime set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fiscal_apuracao_icms set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fiscal_nota_fiscal_saida set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fiscal_termo set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_forma_pagamento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_icms set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fornecedor set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ipi set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_grupo_fiscal set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fpas set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_funcao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_inss set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_grupo_receita set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_local_estoque set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_cana set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_acesso_xml set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_motivo_desoneracao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_modalidade_banco_central_icms_st set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_log_atividades set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_moeda set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_modalidade_banco_central_icms set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ncm set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_municipio set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_cupom_fiscal_referenciado set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_destinatario set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_det_especifico_armamento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_det_especifico_veiculo set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_declaracao_importacao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_configuracao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_det_especifico_combustivel set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_cte_referenciado set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_det_especifico_medicamento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_detalhe_imposto_issqn set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_detalhe_imposto_pis set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_emitente set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_forma_pagamento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_detalhe_imposto_ii set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_detalhe_imposto_cofins set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_detalhe_imposto_icms set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_detalhe_imposto_ipi set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_duplicata set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_exportacao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_fatura set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_local_retirada set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_nf_referenciada set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_processo_referenciado set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_prod_rural_referenciada set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_transporte set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_local_entrega set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_numero set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_referenciada set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nota_fiscal_modelo set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_operadora_cartao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_orcamento_empresarial set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_operadora_plano_saude set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_orcamento_fluxo_caixa set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_transporte_volume_lacre set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_orcamento_fluxo_caixa_detalhe set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_parcelamento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_papel set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_pais set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_patrim_bem set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_orcamento_fluxo_caixa_periodo set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_orcamento_periodo set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_patrim_depreciacao_bem set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_patrim_tipo_aquisicao_bem set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_pedido set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_pedido_receita set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_patrim_indice_atualizacao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_patrim_taxa_depreciacao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_patrim_grupo_bem set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_patrim_documento_bem set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_patrim_tipo_movimentacao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_pessoa_endereco set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_pessoa_telefone set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_pessoa_alteracao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_pessoa_fisica set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_pessoa_juridica set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_pessoa_contato set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_plano_conta set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_regime_tributario set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_pre_venda_cabecalho set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_produto_unidade set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_receita set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_salario_minimo set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_plano_natureza_financeira set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_salario_familia set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_quadro_societario set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_sefip_codigo_recolhimento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_simples_nacional set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_sefip_codigo_movimentacao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_sefip_categoria_trabalho set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_situacao_colaborador set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_sindicato set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_seguradora set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_simples_nacional_cabecalho set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_situacao_tributaria_pis set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_situacao_tributaria_simples_nacional_icms set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_sub_categoria_produto set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_socio set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_situacao_tributaria_ipi set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_situacao_tributaria_icms set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_situacao_pedido set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_situacao_pagamento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tipo_desligamento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tipo_receita_dipi set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tipo_produto_fiscal set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tipo_colaborador set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tabela_preco_produto set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tipo_admissao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tipo_item_sped set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tipo_receita_dacon set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tipo_relacionamento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tribut_icms_uf set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tribut_icms_custom_cab set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tribut_icms_custom_det set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tribut_ipi_dipi set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tribut_iss set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_transportadora set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tribut_grupo_tributario set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_unidade set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_venda_romaneio_entrega set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_vendedor set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_uf set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tribut_pis_cod_apuracao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_venda_orcamento_cabecalho set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_banco set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_convenio set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_cbo set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_almoxarifado set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_conta_caixa set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_dav_detalhe set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_produto set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_pessoa set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_edav_cabecalho set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_aliquota_estadual_pe set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_estoque_produto set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_parcela_receber set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_empresa set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_usuario set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_cod_apuracao_receita_dacon set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_compra_cotacao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_agencia_banco set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_contabil_lancamento_cabecalho set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_compra_cotacao_detalhe set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_compra_cotacao_pedido_detalhe set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_ecf_r02 set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_contabil_lancamento_detalhe set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_empresa_transporte_itinerario set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_contabil_conta set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_efd_tabela_435 set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_empresa_telefone set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_feriados set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_cobranca_parcela_receber set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_atividade_for_cli set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_natureza_financeira set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_lcto_pagar_nt_financeira set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tribut_operacao_fiscal set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_grupo_produto set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_talonario_cheque set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_setor set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nivel_formacao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_plano_conta_ref_sped set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_situacao_for_cli set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fin_lcto_receber_nt_financeira set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_patrim_estado_conservacao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_financeiro_despesas set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fiscal_inscricoes_substitutas set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_detalhe set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_cana_fornecimento_diario set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_patrim_movimentacao_bem set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nota_fiscal_tipo set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_fiscal_parametro set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_inss_detalhe set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_pedido_pagamento set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_transporte_volume set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_orcamento_detalhe set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_importacao_detalhe set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_socio_dependente set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_origem_mercadoria set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_papel_funcao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_socio_participacao_societaria set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_patrim_apolice_seguro set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_cana_deducoes_safra set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_cabecalho set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_nfe_transporte_reboque set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tribut_configura_of_gt set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tabela_preco set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_pre_venda_detalhe set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tribut_cofins_cod_apuracao set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_produto_receita set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_simples_nacional_detalhe set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_venda_cabecalho set ativo=true ;--and versao=0 and data_cadastro=current_date;
update tb_tributacao_normal set ativo=true ;--and versao=0 and data_cadastro=current_date;


ALTER SEQUENCE TB_PESSOA_ID_SEQ RESTART WITH 10;
ALTER SEQUENCE TB_PESSOA_ENDERECO_ID_SEQ RESTART WITH 10;
ALTER SEQUENCE TB_PESSOA_TELEFONE_ID_SEQ RESTART WITH 10;
ALTER SEQUENCE TB_EMPRESA_ID_SEQ RESTART WITH 2;
ALTER SEQUENCE TB_EMPRESA_ENDERECO_ID_SEQ RESTART WITH 2;
ALTER SEQUENCE TB_EMPRESA_TELEFONE_ID_SEQ RESTART WITH 3;
ALTER SEQUENCE TB_CBO_ID_SEQ RESTART WITH 2526;
ALTER SEQUENCE TB_CARGO_ID_SEQ RESTART WITH 2;
ALTER SEQUENCE TB_SETOR_ID_SEQ RESTART WITH 2;
ALTER SEQUENCE TB_NIVEL_FORMACAO_ID_SEQ RESTART WITH 14;
ALTER SEQUENCE TB_TIPO_COLABORADOR_ID_SEQ RESTART WITH 3;
ALTER SEQUENCE TB_SITUACAO_COLABORADOR_ID_SEQ RESTART WITH 2;
ALTER SEQUENCE TB_COLABORADOR_ID_SEQ RESTART WITH 2;
ALTER SEQUENCE TB_CONTADOR_ID_SEQ RESTART WITH 2;
ALTER SEQUENCE TB_BANCO_ID_SEQ RESTART WITH 162;
ALTER SEQUENCE TB_AGENCIA_BANCO_ID_SEQ RESTART WITH 2;
ALTER SEQUENCE TB_CONTA_CAIXA_ID_SEQ RESTART WITH 3;
ALTER SEQUENCE TB_EFD_TABELA_437_ID_SEQ RESTART WITH 19;
ALTER SEQUENCE TB_SEFIP_CATEGORIA_TRABALHO_ID_SEQ RESTART WITH 34;
ALTER SEQUENCE TB_CFOP_ID_SEQ RESTART WITH 542;
ALTER SEQUENCE TB_CNAE_ID_SEQ RESTART WITH 1300;
ALTER SEQUENCE TB_CODIGO_GPS_ID_SEQ RESTART WITH 152;
ALTER SEQUENCE TB_SEFIP_CODIGO_MOVIMENTACAO_ID_SEQ RESTART WITH 31;
ALTER SEQUENCE TB_SEFIP_CODIGO_RECOLHIMENTO_ID_SEQ RESTART WITH 20;
ALTER SEQUENCE TB_CST_ICMS_A_ID_SEQ RESTART WITH 4;
ALTER SEQUENCE TB_CST_ICMS_B_ID_SEQ RESTART WITH 12;
ALTER SEQUENCE TB_CSOSN_A_ID_SEQ RESTART WITH 4;
ALTER SEQUENCE TB_CSOSN_B_ID_SEQ RESTART WITH 11;
ALTER SEQUENCE TB_CST_COFINS_ID_SEQ RESTART WITH 34;
ALTER SEQUENCE TB_CST_IPI_ID_SEQ RESTART WITH 16;
ALTER SEQUENCE TB_CST_PIS_ID_SEQ RESTART WITH 35;
ALTER SEQUENCE TB_FIN_DOCUMENTO_ORIGEM_ID_SEQ RESTART WITH 100;
ALTER SEQUENCE TB_ESTADO_CIVIL_ID_SEQ RESTART WITH 6;
ALTER SEQUENCE TB_FPAS_ID_SEQ RESTART WITH 1414;
ALTER SEQUENCE TB_MOEDA_ID_SEQ RESTART WITH 4;
ALTER SEQUENCE TB_PAIS_ID_SEQ RESTART WITH 239;
ALTER SEQUENCE TB_UF_ID_SEQ RESTART WITH 28;
ALTER SEQUENCE TB_MUNICIPIO_ID_SEQ RESTART WITH 5392;
ALTER SEQUENCE TB_NCM_ID_SEQ RESTART WITH 11565;
ALTER SEQUENCE TB_PESSOA_FISICA_ID_SEQ RESTART WITH 2;
ALTER SEQUENCE TB_PESSOA_JURIDICA_ID_SEQ RESTART WITH 2;
ALTER SEQUENCE TB_SALARIO_MINIMO_ID_SEQ RESTART WITH 3;
ALTER SEQUENCE TB_ATIVIDADE_FOR_CLI_ID_SEQ RESTART WITH 2;
ALTER SEQUENCE TB_SITUACAO_FOR_CLI_ID_SEQ RESTART WITH 2;
ALTER SEQUENCE TB_CLIENTE_ID_SEQ RESTART WITH 2;
ALTER SEQUENCE TB_FORNECEDOR_ID_SEQ RESTART WITH 2; 
ALTER SEQUENCE TB_EFD_TABELA_4310_ID_SEQ RESTART WITH 31;
ALTER SEQUENCE TB_EFD_TABELA_4313_ID_SEQ RESTART WITH 78;
ALTER SEQUENCE TB_EFD_TABELA_4314_ID_SEQ RESTART WITH 19;
ALTER SEQUENCE TB_EFD_TABELA_4315_ID_SEQ RESTART WITH 15;
ALTER SEQUENCE TB_EFD_TABELA_4316_ID_SEQ RESTART WITH 136;
ALTER SEQUENCE TB_EFD_TABELA_439_ID_SEQ RESTART WITH 12;
ALTER SEQUENCE TB_TIPO_ADMISSAO_ID_SEQ RESTART WITH 6;
ALTER SEQUENCE TB_TIPO_DESLIGAMENTO_ID_SEQ RESTART WITH 9;
ALTER SEQUENCE TB_TIPO_ITEM_SPED_ID_SEQ RESTART WITH 13;
ALTER SEQUENCE TB_TIPO_RELACIONAMENTO_ID_SEQ RESTART WITH 9;
--ALTER SEQUENCE TB_UNIDADE_PRODUTO_ID_SEQ RESTART WITH 23;
ALTER SEQUENCE TB_PAPEL_ID_SEQ RESTART WITH 3;
ALTER SEQUENCE TB_USUARIO_ID_SEQ RESTART WITH 3;
ALTER SEQUENCE TB_EMPRESA_PESSOA_ID_SEQ RESTART WITH 2;
ALTER SEQUENCE TB_NOTA_FISCAL_MODELO_ID_SEQ RESTART WITH 33;
ALTER SEQUENCE TB_EFD_TABELA_435_ID_SEQ RESTART WITH 15;
ALTER SEQUENCE TB_tribut_operacao_fiscal_ID_SEQ RESTART WITH 8;
ALTER SEQUENCE TB_tribut_grupo_tributario_ID_SEQ RESTART WITH 5;
ALTER SEQUENCE TB_tribut_configura_of_gt_ID_SEQ RESTART WITH 4;
ALTER SEQUENCE TB_tribut_cofins_cod_apuracao_ID_SEQ RESTART WITH 3;
ALTER SEQUENCE TB_tribut_icms_uf_ID_SEQ RESTART WITH 4;
ALTER SEQUENCE TB_tribut_ipi_dipi_ID_SEQ RESTART WITH 3;
ALTER SEQUENCE TB_tribut_pis_cod_apuracao_ID_SEQ RESTART WITH 3;
ALTER SEQUENCE TB_tribut_icms_custom_cab_ID_SEQ RESTART WITH 2;
ALTER SEQUENCE TB_tribut_icms_custom_det_ID_SEQ RESTART WITH 3;
ALTER SEQUENCE TB_tribut_iss_ID_SEQ RESTART WITH 3;
--ALTER SEQUENCE TB_produto_grupo_ID_SEQ RESTART WITH 3;
--ALTER SEQUENCE TB_produto_sub_grupo_ID_SEQ RESTART WITH 5;
--ALTER SEQUENCE TB_produto_ID_SEQ RESTART WITH 3;
ALTER SEQUENCE TB_nfe_configuracao_ID_SEQ RESTART WITH 2;




update tb_cargo set versao=0 ;-- and data_cadastro=current_date;
update tb_categoria_receita set versao=0 ;-- and data_cadastro=current_date;
update tb_categoria_produto set versao=0 ;-- and data_cadastro=current_date;
update tb_colaborador set versao=0 ;-- and data_cadastro=current_date;
update tb_cheque set versao=0 ;-- and data_cadastro=current_date;
update tb_cliente set versao=0 ;-- and data_cadastro=current_date;
update tb_codigo_apuracao_efd set versao=0 ;-- and data_cadastro=current_date;
update tb_codigo_gps set versao=0 ;-- and data_cadastro=current_date;
update tb_cofins set versao=0 ;-- and data_cadastro=current_date;
update tb_cfop set versao=0 ;-- and data_cadastro=current_date;
update tb_cnae set versao=0 ;-- and data_cadastro=current_date;
update tb_compra_fornecedor_cotacao set versao=0 ;-- and data_cadastro=current_date;
update tb_compra_pedido_detalhe set versao=0 ;-- and data_cadastro=current_date;
update tb_compra_requisicao_detalhe set versao=0 ;-- and data_cadastro=current_date;
update tb_condicoes_pagamento set versao=0 ;-- and data_cadastro=current_date;
update tb_compra_requisicao set versao=0 ;-- and data_cadastro=current_date;
update tb_compra_pedido set versao=0 ;-- and data_cadastro=current_date;
update tb_compra_tipo_requisicao set versao=0 ;-- and data_cadastro=current_date;
update tb_compra_tipo_pedido set versao=0 ;-- and data_cadastro=current_date;
update tb_compra_req_cotacao_detalhe set versao=0 ;-- and data_cadastro=current_date;
update tb_contabil_historico set versao=0 ;-- and data_cadastro=current_date;
update tb_contabil_lote set versao=0 ;-- and data_cadastro=current_date;
update tb_contato set versao=0 ;-- and data_cadastro=current_date;
update tb_contador set versao=0 ;-- and data_cadastro=current_date;
update tb_contrib_sind_patronal_cab set versao=0 ;-- and data_cadastro=current_date;
update tb_contrib_sind_patronal_det set versao=0 ;-- and data_cadastro=current_date;
update tb_csosn_b set versao=0 ;-- and data_cadastro=current_date;
update tb_cst_cofins set versao=0 ;-- and data_cadastro=current_date;
update tb_cst_icms_a set versao=0 ;-- and data_cadastro=current_date;
update tb_cst_icms_b set versao=0 ;-- and data_cadastro=current_date;
update tb_cst_ipi set versao=0 ;-- and data_cadastro=current_date;
update tb_cst_pis set versao=0 ;-- and data_cadastro=current_date;
update tb_credito set versao=0 ;-- and data_cadastro=current_date;
update tb_csosn_a set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_caixa set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_fechamento set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_impressora set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_movimento set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_nota_fiscal_cabecalho set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_nota_fiscal_detalhe set versao=0 ;-- and data_cadastro=current_date;
update tb_dav_detalhe_alteracao set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_aliquotas set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_documentos_emitidos set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_r07 set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_recebimento_nao_fiscal set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_sangria set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_sintegra_60a set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_sintegra_60m set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_suprimento set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_r06 set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_r03 set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_venda_detalhe set versao=0 ;-- and data_cadastro=current_date;
update tb_efd_tabela_4310 set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_venda_cabecalho set versao=0 ;-- and data_cadastro=current_date;
update tb_efd_tabela_4313 set versao=0 ;-- and data_cadastro=current_date;
update tb_efd_tabela_4314 set versao=0 ;-- and data_cadastro=current_date;
update tb_efd_tabela_4315 set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_tipo_pagamento set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_total_tipo_pagamento set versao=0 ;-- and data_cadastro=current_date;
update tb_efd_tabela_437 set versao=0 ;-- and data_cadastro=current_date;
update tb_efd_tabela_439 set versao=0 ;-- and data_cadastro=current_date;
update tb_empresa_cnae set versao=0 ;-- and data_cadastro=current_date;
update tb_efd_tabela_4316 set versao=0 ;-- and data_cadastro=current_date;
update tb_empresa_pessoa set versao=0 ;-- and data_cadastro=current_date;
update tb_empresa_contato set versao=0 ;-- and data_cadastro=current_date;
update tb_empresa_endereco set versao=0 ;-- and data_cadastro=current_date;
update tb_efd_tabela_436 set versao=0 ;-- and data_cadastro=current_date;
update tb_empresa_produto set versao=0 ;-- and data_cadastro=current_date;
update tb_endereco set versao=0 ;-- and data_cadastro=current_date;
update tb_empresa_transporte set versao=0 ;-- and data_cadastro=current_date;
update tb_erro_sistema set versao=0 ;-- and data_cadastro=current_date;
update tb_estado_civil set versao=0 ;-- and data_cadastro=current_date;
update tb_estoque_saida set versao=0 ;-- and data_cadastro=current_date;
update tb_estoque set versao=0 ;-- and data_cadastro=current_date;
update tb_estoque_lancamento set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_configuracao_boleto set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_cheque_emitido set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_documento_origem set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_extrato_conta_banco set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_fechamento_caixa_banco set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_cheque_recebido set versao=0 ;-- and data_cadastro=current_date;
update tb_ficha_tecnica set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_cobranca set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_tipo_recebimento set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_lancamento_receber set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_lancamento_pagar set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_status_parcela set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_tipo_pagamento set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_parcela_pagar set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_parcela_pagamento set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_parcela_recebimento set versao=0 ;-- and data_cadastro=current_date;
update tb_fiscal_estadual_regime set versao=0 ;-- and data_cadastro=current_date;
update tb_fiscal_estadual_porte set versao=0 ;-- and data_cadastro=current_date;
update tb_fiscal_nota_fiscal_entrada set versao=0 ;-- and data_cadastro=current_date;
update tb_fiscal_livro set versao=0 ;-- and data_cadastro=current_date;
update tb_fiscal_municipal_regime set versao=0 ;-- and data_cadastro=current_date;
update tb_fiscal_apuracao_icms set versao=0 ;-- and data_cadastro=current_date;
update tb_fiscal_nota_fiscal_saida set versao=0 ;-- and data_cadastro=current_date;
update tb_fiscal_termo set versao=0 ;-- and data_cadastro=current_date;
update tb_forma_pagamento set versao=0 ;-- and data_cadastro=current_date;
update tb_icms set versao=0 ;-- and data_cadastro=current_date;
update tb_fornecedor set versao=0 ;-- and data_cadastro=current_date;
update tb_ipi set versao=0 ;-- and data_cadastro=current_date;
update tb_grupo_fiscal set versao=0 ;-- and data_cadastro=current_date;
update tb_fpas set versao=0 ;-- and data_cadastro=current_date;
update tb_funcao set versao=0 ;-- and data_cadastro=current_date;
update tb_inss set versao=0 ;-- and data_cadastro=current_date;
update tb_grupo_receita set versao=0 ;-- and data_cadastro=current_date;
update tb_local_estoque set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_cana set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_acesso_xml set versao=0 ;-- and data_cadastro=current_date;
update tb_motivo_desoneracao set versao=0 ;-- and data_cadastro=current_date;
update tb_modalidade_banco_central_icms_st set versao=0 ;-- and data_cadastro=current_date;
update tb_log_atividades set versao=0 ;-- and data_cadastro=current_date;
update tb_moeda set versao=0 ;-- and data_cadastro=current_date;
update tb_modalidade_banco_central_icms set versao=0 ;-- and data_cadastro=current_date;
update tb_ncm set versao=0 ;-- and data_cadastro=current_date;
update tb_municipio set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_cupom_fiscal_referenciado set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_destinatario set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_det_especifico_armamento set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_det_especifico_veiculo set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_declaracao_importacao set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_configuracao set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_det_especifico_combustivel set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_cte_referenciado set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_det_especifico_medicamento set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_detalhe_imposto_issqn set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_detalhe_imposto_pis set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_emitente set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_forma_pagamento set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_detalhe_imposto_ii set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_detalhe_imposto_cofins set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_detalhe_imposto_icms set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_detalhe_imposto_ipi set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_duplicata set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_exportacao set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_fatura set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_local_retirada set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_nf_referenciada set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_processo_referenciado set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_prod_rural_referenciada set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_transporte set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_local_entrega set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_numero set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_referenciada set versao=0 ;-- and data_cadastro=current_date;
update tb_nota_fiscal_modelo set versao=0 ;-- and data_cadastro=current_date;
update tb_operadora_cartao set versao=0 ;-- and data_cadastro=current_date;
update tb_orcamento_empresarial set versao=0 ;-- and data_cadastro=current_date;
update tb_operadora_plano_saude set versao=0 ;-- and data_cadastro=current_date;
update tb_orcamento_fluxo_caixa set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_transporte_volume_lacre set versao=0 ;-- and data_cadastro=current_date;
update tb_orcamento_fluxo_caixa_detalhe set versao=0 ;-- and data_cadastro=current_date;
update tb_parcelamento set versao=0 ;-- and data_cadastro=current_date;
update tb_papel set versao=0 ;-- and data_cadastro=current_date;
update tb_pais set versao=0 ;-- and data_cadastro=current_date;
update tb_patrim_bem set versao=0 ;-- and data_cadastro=current_date;
update tb_orcamento_fluxo_caixa_periodo set versao=0 ;-- and data_cadastro=current_date;
update tb_orcamento_periodo set versao=0 ;-- and data_cadastro=current_date;
update tb_patrim_depreciacao_bem set versao=0 ;-- and data_cadastro=current_date;
update tb_patrim_tipo_aquisicao_bem set versao=0 ;-- and data_cadastro=current_date;
update tb_pedido set versao=0 ;-- and data_cadastro=current_date;
update tb_pedido_receita set versao=0 ;-- and data_cadastro=current_date;
update tb_patrim_indice_atualizacao set versao=0 ;-- and data_cadastro=current_date;
update tb_patrim_taxa_depreciacao set versao=0 ;-- and data_cadastro=current_date;
update tb_patrim_grupo_bem set versao=0 ;-- and data_cadastro=current_date;
update tb_patrim_documento_bem set versao=0 ;-- and data_cadastro=current_date;
update tb_patrim_tipo_movimentacao set versao=0 ;-- and data_cadastro=current_date;
update tb_pessoa_endereco set versao=0 ;-- and data_cadastro=current_date;
update tb_pessoa_telefone set versao=0 ;-- and data_cadastro=current_date;
update tb_pessoa_alteracao set versao=0 ;-- and data_cadastro=current_date;
update tb_pessoa_fisica set versao=0 ;-- and data_cadastro=current_date;
update tb_pessoa_juridica set versao=0 ;-- and data_cadastro=current_date;
update tb_pessoa_contato set versao=0 ;-- and data_cadastro=current_date;
update tb_plano_conta set versao=0 ;-- and data_cadastro=current_date;
update tb_regime_tributario set versao=0 ;-- and data_cadastro=current_date;
update tb_pre_venda_cabecalho set versao=0 ;-- and data_cadastro=current_date;
update tb_produto_unidade set versao=0 ;-- and data_cadastro=current_date;
update tb_receita set versao=0 ;-- and data_cadastro=current_date;
update tb_salario_minimo set versao=0 ;-- and data_cadastro=current_date;
update tb_plano_natureza_financeira set versao=0 ;-- and data_cadastro=current_date;
update tb_salario_familia set versao=0 ;-- and data_cadastro=current_date;
update tb_quadro_societario set versao=0 ;-- and data_cadastro=current_date;
update tb_sefip_codigo_recolhimento set versao=0 ;-- and data_cadastro=current_date;
update tb_simples_nacional set versao=0 ;-- and data_cadastro=current_date;
update tb_sefip_codigo_movimentacao set versao=0 ;-- and data_cadastro=current_date;
update tb_sefip_categoria_trabalho set versao=0 ;-- and data_cadastro=current_date;
update tb_situacao_colaborador set versao=0 ;-- and data_cadastro=current_date;
update tb_sindicato set versao=0 ;-- and data_cadastro=current_date;
update tb_seguradora set versao=0 ;-- and data_cadastro=current_date;
update tb_simples_nacional_cabecalho set versao=0 ;-- and data_cadastro=current_date;
update tb_situacao_tributaria_pis set versao=0 ;-- and data_cadastro=current_date;
update tb_situacao_tributaria_simples_nacional_icms set versao=0 ;-- and data_cadastro=current_date;
update tb_sub_categoria_produto set versao=0 ;-- and data_cadastro=current_date;
update tb_socio set versao=0 ;-- and data_cadastro=current_date;
update tb_situacao_tributaria_ipi set versao=0 ;-- and data_cadastro=current_date;
update tb_situacao_tributaria_icms set versao=0 ;-- and data_cadastro=current_date;
update tb_situacao_pedido set versao=0 ;-- and data_cadastro=current_date;
update tb_situacao_pagamento set versao=0 ;-- and data_cadastro=current_date;
update tb_tipo_desligamento set versao=0 ;-- and data_cadastro=current_date;
update tb_tipo_receita_dipi set versao=0 ;-- and data_cadastro=current_date;
update tb_tipo_produto_fiscal set versao=0 ;-- and data_cadastro=current_date;
update tb_tipo_colaborador set versao=0 ;-- and data_cadastro=current_date;
update tb_tabela_preco_produto set versao=0 ;-- and data_cadastro=current_date;
update tb_tipo_admissao set versao=0 ;-- and data_cadastro=current_date;
update tb_tipo_item_sped set versao=0 ;-- and data_cadastro=current_date;
update tb_tipo_receita_dacon set versao=0 ;-- and data_cadastro=current_date;
update tb_tipo_relacionamento set versao=0 ;-- and data_cadastro=current_date;
update tb_tribut_icms_uf set versao=0 ;-- and data_cadastro=current_date;
update tb_tribut_icms_custom_cab set versao=0 ;-- and data_cadastro=current_date;
update tb_tribut_icms_custom_det set versao=0 ;-- and data_cadastro=current_date;
update tb_tribut_ipi_dipi set versao=0 ;-- and data_cadastro=current_date;
update tb_tribut_iss set versao=0 ;-- and data_cadastro=current_date;
update tb_transportadora set versao=0 ;-- and data_cadastro=current_date;
update tb_tribut_grupo_tributario set versao=0 ;-- and data_cadastro=current_date;
update tb_unidade set versao=0 ;-- and data_cadastro=current_date;
update tb_venda_romaneio_entrega set versao=0 ;-- and data_cadastro=current_date;
update tb_vendedor set versao=0 ;-- and data_cadastro=current_date;
update tb_uf set versao=0 ;-- and data_cadastro=current_date;
update tb_tribut_pis_cod_apuracao set versao=0 ;-- and data_cadastro=current_date;
update tb_venda_orcamento_cabecalho set versao=0 ;-- and data_cadastro=current_date;
update tb_banco set versao=0 ;-- and data_cadastro=current_date;
update tb_convenio set versao=0 ;-- and data_cadastro=current_date;
update tb_cbo set versao=0 ;-- and data_cadastro=current_date;
update tb_almoxarifado set versao=0 ;-- and data_cadastro=current_date;
update tb_conta_caixa set versao=0 ;-- and data_cadastro=current_date;
update tb_dav_detalhe set versao=0 ;-- and data_cadastro=current_date;
update tb_produto set versao=0 ;-- and data_cadastro=current_date;
update tb_pessoa set versao=0 ;-- and data_cadastro=current_date;
update tb_edav_cabecalho set versao=0 ;-- and data_cadastro=current_date;
update tb_aliquota_estadual_pe set versao=0 ;-- and data_cadastro=current_date;
update tb_estoque_produto set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_parcela_receber set versao=0 ;-- and data_cadastro=current_date;
update tb_empresa set versao=0 ;-- and data_cadastro=current_date;
update tb_usuario set versao=0 ;-- and data_cadastro=current_date;
update tb_cod_apuracao_receita_dacon set versao=0 ;-- and data_cadastro=current_date;
update tb_compra_cotacao set versao=0 ;-- and data_cadastro=current_date;
update tb_agencia_banco set versao=0 ;-- and data_cadastro=current_date;
update tb_contabil_lancamento_cabecalho set versao=0 ;-- and data_cadastro=current_date;
update tb_compra_cotacao_detalhe set versao=0 ;-- and data_cadastro=current_date;
update tb_compra_cotacao_pedido_detalhe set versao=0 ;-- and data_cadastro=current_date;
update tb_ecf_r02 set versao=0 ;-- and data_cadastro=current_date;
update tb_contabil_lancamento_detalhe set versao=0 ;-- and data_cadastro=current_date;
update tb_empresa_transporte_itinerario set versao=0 ;-- and data_cadastro=current_date;
update tb_contabil_conta set versao=0 ;-- and data_cadastro=current_date;
update tb_efd_tabela_435 set versao=0 ;-- and data_cadastro=current_date;
update tb_empresa_telefone set versao=0 ;-- and data_cadastro=current_date;
update tb_feriados set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_cobranca_parcela_receber set versao=0 ;-- and data_cadastro=current_date;
update tb_atividade_for_cli set versao=0 ;-- and data_cadastro=current_date;
update tb_natureza_financeira set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_lcto_pagar_nt_financeira set versao=0 ;-- and data_cadastro=current_date;
update tb_tribut_operacao_fiscal set versao=0 ;-- and data_cadastro=current_date;
update tb_grupo_produto set versao=0 ;-- and data_cadastro=current_date;
update tb_talonario_cheque set versao=0 ;-- and data_cadastro=current_date;
update tb_setor set versao=0 ;-- and data_cadastro=current_date;
update tb_nivel_formacao set versao=0 ;-- and data_cadastro=current_date;
update tb_plano_conta_ref_sped set versao=0 ;-- and data_cadastro=current_date;
update tb_situacao_for_cli set versao=0 ;-- and data_cadastro=current_date;
update tb_fin_lcto_receber_nt_financeira set versao=0 ;-- and data_cadastro=current_date;
update tb_patrim_estado_conservacao set versao=0 ;-- and data_cadastro=current_date;
update tb_financeiro_despesas set versao=0 ;-- and data_cadastro=current_date;
update tb_fiscal_inscricoes_substitutas set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_detalhe set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_cana_fornecimento_diario set versao=0 ;-- and data_cadastro=current_date;
update tb_patrim_movimentacao_bem set versao=0 ;-- and data_cadastro=current_date;
update tb_nota_fiscal_tipo set versao=0 ;-- and data_cadastro=current_date;
update tb_fiscal_parametro set versao=0 ;-- and data_cadastro=current_date;
update tb_inss_detalhe set versao=0 ;-- and data_cadastro=current_date;
update tb_pedido_pagamento set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_transporte_volume set versao=0 ;-- and data_cadastro=current_date;
update tb_orcamento_detalhe set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_importacao_detalhe set versao=0 ;-- and data_cadastro=current_date;
update tb_socio_dependente set versao=0 ;-- and data_cadastro=current_date;
update tb_origem_mercadoria set versao=0 ;-- and data_cadastro=current_date;
update tb_papel_funcao set versao=0 ;-- and data_cadastro=current_date;
update tb_socio_participacao_societaria set versao=0 ;-- and data_cadastro=current_date;
update tb_patrim_apolice_seguro set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_cana_deducoes_safra set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_cabecalho set versao=0 ;-- and data_cadastro=current_date;
update tb_nfe_transporte_reboque set versao=0 ;-- and data_cadastro=current_date;
update tb_tribut_configura_of_gt set versao=0 ;-- and data_cadastro=current_date;
update tb_tabela_preco set versao=0 ;-- and data_cadastro=current_date;
update tb_pre_venda_detalhe set versao=0 ;-- and data_cadastro=current_date;
update tb_tribut_cofins_cod_apuracao set versao=0 ;-- and data_cadastro=current_date;
update tb_produto_receita set versao=0 ;-- and data_cadastro=current_date;
update tb_simples_nacional_detalhe set versao=0 ;-- and data_cadastro=current_date;
update tb_venda_cabecalho set versao=0 ;-- and data_cadastro=current_date;
update tb_tributacao_normal set versao=0 ;-- and data_cadastro=current_date;




update tb_cargo set data_cadastro=current_date;
update tb_categoria_receita set data_cadastro=current_date;
update tb_categoria_produto set data_cadastro=current_date;
update tb_colaborador set data_cadastro=current_date;
update tb_cheque set data_cadastro=current_date;
update tb_cliente set data_cadastro=current_date;
update tb_codigo_apuracao_efd set data_cadastro=current_date;
update tb_codigo_gps set data_cadastro=current_date;
update tb_cofins set data_cadastro=current_date;
update tb_cfop set data_cadastro=current_date;
update tb_cnae set data_cadastro=current_date;
update tb_compra_fornecedor_cotacao set data_cadastro=current_date;
update tb_compra_pedido_detalhe set data_cadastro=current_date;
update tb_compra_requisicao_detalhe set data_cadastro=current_date;
update tb_condicoes_pagamento set data_cadastro=current_date;
update tb_compra_requisicao set data_cadastro=current_date;
update tb_compra_pedido set data_cadastro=current_date;
update tb_compra_tipo_requisicao set data_cadastro=current_date;
update tb_compra_tipo_pedido set data_cadastro=current_date;
update tb_compra_req_cotacao_detalhe set data_cadastro=current_date;
update tb_contabil_historico set data_cadastro=current_date;
update tb_contabil_lote set data_cadastro=current_date;
update tb_contato set data_cadastro=current_date;
update tb_contador set data_cadastro=current_date;
update tb_contrib_sind_patronal_cab set data_cadastro=current_date;
update tb_contrib_sind_patronal_det set data_cadastro=current_date;
update tb_csosn_b set data_cadastro=current_date;
update tb_cst_cofins set data_cadastro=current_date;
update tb_cst_icms_a set data_cadastro=current_date;
update tb_cst_icms_b set data_cadastro=current_date;
update tb_cst_ipi set data_cadastro=current_date;
update tb_cst_pis set data_cadastro=current_date;
update tb_credito set data_cadastro=current_date;
update tb_csosn_a set data_cadastro=current_date;
update tb_ecf_caixa set data_cadastro=current_date;
update tb_ecf_fechamento set data_cadastro=current_date;
update tb_ecf_impressora set data_cadastro=current_date;
update tb_ecf_movimento set data_cadastro=current_date;
update tb_ecf_nota_fiscal_cabecalho set data_cadastro=current_date;
update tb_ecf_nota_fiscal_detalhe set data_cadastro=current_date;
update tb_dav_detalhe_alteracao set data_cadastro=current_date;
update tb_ecf_aliquotas set data_cadastro=current_date;
update tb_ecf_documentos_emitidos set data_cadastro=current_date;
update tb_ecf_r07 set data_cadastro=current_date;
update tb_ecf_recebimento_nao_fiscal set data_cadastro=current_date;
update tb_ecf_sangria set data_cadastro=current_date;
update tb_ecf_sintegra_60a set data_cadastro=current_date;
update tb_ecf_sintegra_60m set data_cadastro=current_date;
update tb_ecf_suprimento set data_cadastro=current_date;
update tb_ecf_r06 set data_cadastro=current_date;
update tb_ecf_r03 set data_cadastro=current_date;
update tb_ecf_venda_detalhe set data_cadastro=current_date;
update tb_efd_tabela_4310 set data_cadastro=current_date;
update tb_ecf_venda_cabecalho set data_cadastro=current_date;
update tb_efd_tabela_4313 set data_cadastro=current_date;
update tb_efd_tabela_4314 set data_cadastro=current_date;
update tb_efd_tabela_4315 set data_cadastro=current_date;
update tb_ecf_tipo_pagamento set data_cadastro=current_date;
update tb_ecf_total_tipo_pagamento set data_cadastro=current_date;
update tb_efd_tabela_437 set data_cadastro=current_date;
update tb_efd_tabela_439 set data_cadastro=current_date;
update tb_empresa_cnae set data_cadastro=current_date;
update tb_efd_tabela_4316 set data_cadastro=current_date;
update tb_empresa_pessoa set data_cadastro=current_date;
update tb_empresa_contato set data_cadastro=current_date;
update tb_empresa_endereco set data_cadastro=current_date;
update tb_efd_tabela_436 set data_cadastro=current_date;
update tb_empresa_produto set data_cadastro=current_date;
update tb_endereco set data_cadastro=current_date;
update tb_empresa_transporte set data_cadastro=current_date;
update tb_erro_sistema set data_cadastro=current_date;
update tb_estado_civil set data_cadastro=current_date;
update tb_estoque_saida set data_cadastro=current_date;
update tb_estoque set data_cadastro=current_date;
update tb_estoque_lancamento set data_cadastro=current_date;
update tb_fin_configuracao_boleto set data_cadastro=current_date;
update tb_fin_cheque_emitido set data_cadastro=current_date;
update tb_fin_documento_origem set data_cadastro=current_date;
update tb_fin_extrato_conta_banco set data_cadastro=current_date;
update tb_fin_fechamento_caixa_banco set data_cadastro=current_date;
update tb_fin_cheque_recebido set data_cadastro=current_date;
update tb_ficha_tecnica set data_cadastro=current_date;
update tb_fin_cobranca set data_cadastro=current_date;
update tb_fin_tipo_recebimento set data_cadastro=current_date;
update tb_fin_lancamento_receber set data_cadastro=current_date;
update tb_fin_lancamento_pagar set data_cadastro=current_date;
update tb_fin_status_parcela set data_cadastro=current_date;
update tb_fin_tipo_pagamento set data_cadastro=current_date;
update tb_fin_parcela_pagar set data_cadastro=current_date;
update tb_fin_parcela_pagamento set data_cadastro=current_date;
update tb_fin_parcela_recebimento set data_cadastro=current_date;
update tb_fiscal_estadual_regime set data_cadastro=current_date;
update tb_fiscal_estadual_porte set data_cadastro=current_date;
update tb_fiscal_nota_fiscal_entrada set data_cadastro=current_date;
update tb_fiscal_livro set data_cadastro=current_date;
update tb_fiscal_municipal_regime set data_cadastro=current_date;
update tb_fiscal_apuracao_icms set data_cadastro=current_date;
update tb_fiscal_nota_fiscal_saida set data_cadastro=current_date;
update tb_fiscal_termo set data_cadastro=current_date;
update tb_forma_pagamento set data_cadastro=current_date;
update tb_icms set data_cadastro=current_date;
update tb_fornecedor set data_cadastro=current_date;
update tb_ipi set data_cadastro=current_date;
update tb_grupo_fiscal set data_cadastro=current_date;
update tb_fpas set data_cadastro=current_date;
update tb_funcao set data_cadastro=current_date;
update tb_inss set data_cadastro=current_date;
update tb_grupo_receita set data_cadastro=current_date;
update tb_local_estoque set data_cadastro=current_date;
update tb_nfe_cana set data_cadastro=current_date;
update tb_nfe_acesso_xml set data_cadastro=current_date;
update tb_motivo_desoneracao set data_cadastro=current_date;
update tb_modalidade_banco_central_icms_st set data_cadastro=current_date;
update tb_log_atividades set data_cadastro=current_date;
update tb_moeda set data_cadastro=current_date;
update tb_modalidade_banco_central_icms set data_cadastro=current_date;
update tb_ncm set data_cadastro=current_date;
update tb_municipio set data_cadastro=current_date;
update tb_nfe_cupom_fiscal_referenciado set data_cadastro=current_date;
update tb_nfe_destinatario set data_cadastro=current_date;
update tb_nfe_det_especifico_armamento set data_cadastro=current_date;
update tb_nfe_det_especifico_veiculo set data_cadastro=current_date;
update tb_nfe_declaracao_importacao set data_cadastro=current_date;
update tb_nfe_configuracao set data_cadastro=current_date;
update tb_nfe_det_especifico_combustivel set data_cadastro=current_date;
update tb_nfe_cte_referenciado set data_cadastro=current_date;
update tb_nfe_det_especifico_medicamento set data_cadastro=current_date;
update tb_nfe_detalhe_imposto_issqn set data_cadastro=current_date;
update tb_nfe_detalhe_imposto_pis set data_cadastro=current_date;
update tb_nfe_emitente set data_cadastro=current_date;
update tb_nfe_forma_pagamento set data_cadastro=current_date;
update tb_nfe_detalhe_imposto_ii set data_cadastro=current_date;
update tb_nfe_detalhe_imposto_cofins set data_cadastro=current_date;
update tb_nfe_detalhe_imposto_icms set data_cadastro=current_date;
update tb_nfe_detalhe_imposto_ipi set data_cadastro=current_date;
update tb_nfe_duplicata set data_cadastro=current_date;
update tb_nfe_exportacao set data_cadastro=current_date;
update tb_nfe_fatura set data_cadastro=current_date;
update tb_nfe_local_retirada set data_cadastro=current_date;
update tb_nfe_nf_referenciada set data_cadastro=current_date;
update tb_nfe_processo_referenciado set data_cadastro=current_date;
update tb_nfe_prod_rural_referenciada set data_cadastro=current_date;
update tb_nfe_transporte set data_cadastro=current_date;
update tb_nfe_local_entrega set data_cadastro=current_date;
update tb_nfe_numero set data_cadastro=current_date;
update tb_nfe_referenciada set data_cadastro=current_date;
update tb_nota_fiscal_modelo set data_cadastro=current_date;
update tb_operadora_cartao set data_cadastro=current_date;
update tb_orcamento_empresarial set data_cadastro=current_date;
update tb_operadora_plano_saude set data_cadastro=current_date;
update tb_orcamento_fluxo_caixa set data_cadastro=current_date;
update tb_nfe_transporte_volume_lacre set data_cadastro=current_date;
update tb_orcamento_fluxo_caixa_detalhe set data_cadastro=current_date;
update tb_parcelamento set data_cadastro=current_date;
update tb_papel set data_cadastro=current_date;
update tb_pais set data_cadastro=current_date;
update tb_patrim_bem set data_cadastro=current_date;
update tb_orcamento_fluxo_caixa_periodo set data_cadastro=current_date;
update tb_orcamento_periodo set data_cadastro=current_date;
update tb_patrim_depreciacao_bem set data_cadastro=current_date;
update tb_patrim_tipo_aquisicao_bem set data_cadastro=current_date;
update tb_pedido set data_cadastro=current_date;
update tb_pedido_receita set data_cadastro=current_date;
update tb_patrim_indice_atualizacao set data_cadastro=current_date;
update tb_patrim_taxa_depreciacao set data_cadastro=current_date;
update tb_patrim_grupo_bem set data_cadastro=current_date;
update tb_patrim_documento_bem set data_cadastro=current_date;
update tb_patrim_tipo_movimentacao set data_cadastro=current_date;
update tb_pessoa_endereco set data_cadastro=current_date;
update tb_pessoa_telefone set data_cadastro=current_date;
update tb_pessoa_alteracao set data_cadastro=current_date;
update tb_pessoa_fisica set data_cadastro=current_date;
update tb_pessoa_juridica set data_cadastro=current_date;
update tb_pessoa_contato set data_cadastro=current_date;
update tb_plano_conta set data_cadastro=current_date;
update tb_regime_tributario set data_cadastro=current_date;
update tb_pre_venda_cabecalho set data_cadastro=current_date;
update tb_produto_unidade set data_cadastro=current_date;
update tb_receita set data_cadastro=current_date;
update tb_salario_minimo set data_cadastro=current_date;
update tb_plano_natureza_financeira set data_cadastro=current_date;
update tb_salario_familia set data_cadastro=current_date;
update tb_quadro_societario set data_cadastro=current_date;
update tb_sefip_codigo_recolhimento set data_cadastro=current_date;
update tb_simples_nacional set data_cadastro=current_date;
update tb_sefip_codigo_movimentacao set data_cadastro=current_date;
update tb_sefip_categoria_trabalho set data_cadastro=current_date;
update tb_situacao_colaborador set data_cadastro=current_date;
update tb_sindicato set data_cadastro=current_date;
update tb_seguradora set data_cadastro=current_date;
update tb_simples_nacional_cabecalho set data_cadastro=current_date;
update tb_situacao_tributaria_pis set data_cadastro=current_date;
update tb_situacao_tributaria_simples_nacional_icms set data_cadastro=current_date;
update tb_sub_categoria_produto set data_cadastro=current_date;
update tb_socio set data_cadastro=current_date;
update tb_situacao_tributaria_ipi set data_cadastro=current_date;
update tb_situacao_tributaria_icms set data_cadastro=current_date;
update tb_situacao_pedido set data_cadastro=current_date;
update tb_situacao_pagamento set data_cadastro=current_date;
update tb_tipo_desligamento set data_cadastro=current_date;
update tb_tipo_receita_dipi set data_cadastro=current_date;
update tb_tipo_produto_fiscal set data_cadastro=current_date;
update tb_tipo_colaborador set data_cadastro=current_date;
update tb_tabela_preco_produto set data_cadastro=current_date;
update tb_tipo_admissao set data_cadastro=current_date;
update tb_tipo_item_sped set data_cadastro=current_date;
update tb_tipo_receita_dacon set data_cadastro=current_date;
update tb_tipo_relacionamento set data_cadastro=current_date;
update tb_tribut_icms_uf set data_cadastro=current_date;
update tb_tribut_icms_custom_cab set data_cadastro=current_date;
update tb_tribut_icms_custom_det set data_cadastro=current_date;
update tb_tribut_ipi_dipi set data_cadastro=current_date;
update tb_tribut_iss set data_cadastro=current_date;
update tb_transportadora set data_cadastro=current_date;
update tb_tribut_grupo_tributario set data_cadastro=current_date;
update tb_unidade set data_cadastro=current_date;
update tb_venda_romaneio_entrega set data_cadastro=current_date;
update tb_vendedor set data_cadastro=current_date;
update tb_uf set data_cadastro=current_date;
update tb_tribut_pis_cod_apuracao set data_cadastro=current_date;
update tb_venda_orcamento_cabecalho set data_cadastro=current_date;
update tb_banco set data_cadastro=current_date;
update tb_convenio set data_cadastro=current_date;
update tb_cbo set data_cadastro=current_date;
update tb_almoxarifado set data_cadastro=current_date;
update tb_conta_caixa set data_cadastro=current_date;
update tb_dav_detalhe set data_cadastro=current_date;
update tb_produto set data_cadastro=current_date;
update tb_pessoa set data_cadastro=current_date;
update tb_edav_cabecalho set data_cadastro=current_date;
update tb_aliquota_estadual_pe set data_cadastro=current_date;
update tb_estoque_produto set data_cadastro=current_date;
update tb_fin_parcela_receber set data_cadastro=current_date;
update tb_empresa set data_cadastro=current_date;
update tb_usuario set data_cadastro=current_date;
update tb_cod_apuracao_receita_dacon set data_cadastro=current_date;
update tb_compra_cotacao set data_cadastro=current_date;
update tb_agencia_banco set data_cadastro=current_date;
update tb_contabil_lancamento_cabecalho set data_cadastro=current_date;
update tb_compra_cotacao_detalhe set data_cadastro=current_date;
update tb_compra_cotacao_pedido_detalhe set data_cadastro=current_date;
update tb_ecf_r02 set data_cadastro=current_date;
update tb_contabil_lancamento_detalhe set data_cadastro=current_date;
update tb_empresa_transporte_itinerario set data_cadastro=current_date;
update tb_contabil_conta set data_cadastro=current_date;
update tb_efd_tabela_435 set data_cadastro=current_date;
update tb_empresa_telefone set data_cadastro=current_date;
update tb_feriados set data_cadastro=current_date;
update tb_fin_cobranca_parcela_receber set data_cadastro=current_date;
update tb_atividade_for_cli set data_cadastro=current_date;
update tb_natureza_financeira set data_cadastro=current_date;
update tb_fin_lcto_pagar_nt_financeira set data_cadastro=current_date;
update tb_tribut_operacao_fiscal set data_cadastro=current_date;
update tb_grupo_produto set data_cadastro=current_date;
update tb_talonario_cheque set data_cadastro=current_date;
update tb_setor set data_cadastro=current_date;
update tb_nivel_formacao set data_cadastro=current_date;
update tb_plano_conta_ref_sped set data_cadastro=current_date;
update tb_situacao_for_cli set data_cadastro=current_date;
update tb_fin_lcto_receber_nt_financeira set data_cadastro=current_date;
update tb_patrim_estado_conservacao set data_cadastro=current_date;
update tb_financeiro_despesas set data_cadastro=current_date;
update tb_fiscal_inscricoes_substitutas set data_cadastro=current_date;
update tb_nfe_detalhe set data_cadastro=current_date;
update tb_nfe_cana_fornecimento_diario set data_cadastro=current_date;
update tb_patrim_movimentacao_bem set data_cadastro=current_date;
update tb_nota_fiscal_tipo set data_cadastro=current_date;
update tb_fiscal_parametro set data_cadastro=current_date;
update tb_inss_detalhe set data_cadastro=current_date;
update tb_pedido_pagamento set data_cadastro=current_date;
update tb_nfe_transporte_volume set data_cadastro=current_date;
update tb_orcamento_detalhe set data_cadastro=current_date;
update tb_nfe_importacao_detalhe set data_cadastro=current_date;
update tb_socio_dependente set data_cadastro=current_date;
update tb_origem_mercadoria set data_cadastro=current_date;
update tb_papel_funcao set data_cadastro=current_date;
update tb_socio_participacao_societaria set data_cadastro=current_date;
update tb_patrim_apolice_seguro set data_cadastro=current_date;
update tb_nfe_cana_deducoes_safra set data_cadastro=current_date;
update tb_nfe_cabecalho set data_cadastro=current_date;
update tb_nfe_transporte_reboque set data_cadastro=current_date;
update tb_tribut_configura_of_gt set data_cadastro=current_date;
update tb_tabela_preco set data_cadastro=current_date;
update tb_pre_venda_detalhe set data_cadastro=current_date;
update tb_tribut_cofins_cod_apuracao set data_cadastro=current_date;
update tb_produto_receita set data_cadastro=current_date;
update tb_simples_nacional_detalhe set data_cadastro=current_date;
update tb_venda_cabecalho set data_cadastro=current_date;
update tb_tributacao_normal set data_cadastro=current_date;







update tb_cargo set fk_id_empresa=1;
update tb_categoria_receita set fk_id_empresa=1;
update tb_categoria_produto set fk_id_empresa=1;
update tb_colaborador set fk_id_empresa=1;
update tb_cheque set fk_id_empresa=1;
update tb_cliente set fk_id_empresa=1;
update tb_codigo_apuracao_efd set fk_id_empresa=1;
update tb_codigo_gps set fk_id_empresa=1;
update tb_cofins set fk_id_empresa=1;
update tb_cfop set fk_id_empresa=1;
update tb_cnae set fk_id_empresa=1;
update tb_compra_fornecedor_cotacao set fk_id_empresa=1;
update tb_compra_pedido_detalhe set fk_id_empresa=1;
update tb_compra_requisicao_detalhe set fk_id_empresa=1;
update tb_condicoes_pagamento set fk_id_empresa=1;
update tb_compra_requisicao set fk_id_empresa=1;
update tb_compra_pedido set fk_id_empresa=1;
update tb_compra_tipo_requisicao set fk_id_empresa=1;
update tb_compra_tipo_pedido set fk_id_empresa=1;
update tb_compra_req_cotacao_detalhe set fk_id_empresa=1;
update tb_contabil_historico set fk_id_empresa=1;
update tb_contabil_lote set fk_id_empresa=1;
update tb_contato set fk_id_empresa=1;
update tb_contador set fk_id_empresa=1;
update tb_contrib_sind_patronal_cab set fk_id_empresa=1;
update tb_contrib_sind_patronal_det set fk_id_empresa=1;
update tb_csosn_b set fk_id_empresa=1;
update tb_cst_cofins set fk_id_empresa=1;
update tb_cst_icms_a set fk_id_empresa=1;
update tb_cst_icms_b set fk_id_empresa=1;
update tb_cst_ipi set fk_id_empresa=1;
update tb_cst_pis set fk_id_empresa=1;
update tb_credito set fk_id_empresa=1;
update tb_csosn_a set fk_id_empresa=1;
update tb_ecf_caixa set fk_id_empresa=1;
update tb_ecf_fechamento set fk_id_empresa=1;
update tb_ecf_impressora set fk_id_empresa=1;
update tb_ecf_movimento set fk_id_empresa=1;
update tb_ecf_nota_fiscal_cabecalho set fk_id_empresa=1;
update tb_ecf_nota_fiscal_detalhe set fk_id_empresa=1;
update tb_dav_detalhe_alteracao set fk_id_empresa=1;
update tb_ecf_aliquotas set fk_id_empresa=1;
update tb_ecf_documentos_emitidos set fk_id_empresa=1;
update tb_ecf_r07 set fk_id_empresa=1;
update tb_ecf_recebimento_nao_fiscal set fk_id_empresa=1;
update tb_ecf_sangria set fk_id_empresa=1;
update tb_ecf_sintegra_60a set fk_id_empresa=1;
update tb_ecf_sintegra_60m set fk_id_empresa=1;
update tb_ecf_suprimento set fk_id_empresa=1;
update tb_ecf_r06 set fk_id_empresa=1;
update tb_ecf_r03 set fk_id_empresa=1;
update tb_ecf_venda_detalhe set fk_id_empresa=1;
update tb_efd_tabela_4310 set fk_id_empresa=1;
update tb_ecf_venda_cabecalho set fk_id_empresa=1;
update tb_efd_tabela_4313 set fk_id_empresa=1;
update tb_efd_tabela_4314 set fk_id_empresa=1;
update tb_efd_tabela_4315 set fk_id_empresa=1;
update tb_ecf_tipo_pagamento set fk_id_empresa=1;
update tb_ecf_total_tipo_pagamento set fk_id_empresa=1;
update tb_efd_tabela_437 set fk_id_empresa=1;
update tb_efd_tabela_439 set fk_id_empresa=1;
update tb_empresa_cnae set fk_id_empresa=1;
update tb_efd_tabela_4316 set fk_id_empresa=1;
update tb_empresa_pessoa set fk_id_empresa=1;
update tb_empresa_contato set fk_id_empresa=1;
update tb_empresa_endereco set fk_id_empresa=1;
update tb_efd_tabela_436 set fk_id_empresa=1;
update tb_empresa_produto set fk_id_empresa=1;
update tb_endereco set fk_id_empresa=1;
update tb_empresa_transporte set fk_id_empresa=1;
update tb_erro_sistema set fk_id_empresa=1;
update tb_estado_civil set fk_id_empresa=1;
update tb_estoque_saida set fk_id_empresa=1;
update tb_estoque set fk_id_empresa=1;
update tb_estoque_lancamento set fk_id_empresa=1;
update tb_fin_configuracao_boleto set fk_id_empresa=1;
update tb_fin_cheque_emitido set fk_id_empresa=1;
update tb_fin_documento_origem set fk_id_empresa=1;
update tb_fin_extrato_conta_banco set fk_id_empresa=1;
update tb_fin_fechamento_caixa_banco set fk_id_empresa=1;
update tb_fin_cheque_recebido set fk_id_empresa=1;
update tb_ficha_tecnica set fk_id_empresa=1;
update tb_fin_cobranca set fk_id_empresa=1;
update tb_fin_tipo_recebimento set fk_id_empresa=1;
update tb_fin_lancamento_receber set fk_id_empresa=1;
update tb_fin_lancamento_pagar set fk_id_empresa=1;
update tb_fin_status_parcela set fk_id_empresa=1;
update tb_fin_tipo_pagamento set fk_id_empresa=1;
update tb_fin_parcela_pagar set fk_id_empresa=1;
update tb_fin_parcela_pagamento set fk_id_empresa=1;
update tb_fin_parcela_recebimento set fk_id_empresa=1;
update tb_fiscal_estadual_regime set fk_id_empresa=1;
update tb_fiscal_estadual_porte set fk_id_empresa=1;
update tb_fiscal_nota_fiscal_entrada set fk_id_empresa=1;
update tb_fiscal_livro set fk_id_empresa=1;
update tb_fiscal_municipal_regime set fk_id_empresa=1;
update tb_fiscal_apuracao_icms set fk_id_empresa=1;
update tb_fiscal_nota_fiscal_saida set fk_id_empresa=1;
update tb_fiscal_termo set fk_id_empresa=1;
update tb_forma_pagamento set fk_id_empresa=1;
update tb_icms set fk_id_empresa=1;
update tb_fornecedor set fk_id_empresa=1;
update tb_ipi set fk_id_empresa=1;
update tb_grupo_fiscal set fk_id_empresa=1;
update tb_fpas set fk_id_empresa=1;
update tb_funcao set fk_id_empresa=1;
update tb_inss set fk_id_empresa=1;
update tb_grupo_receita set fk_id_empresa=1;
update tb_local_estoque set fk_id_empresa=1;
update tb_nfe_cana set fk_id_empresa=1;
update tb_nfe_acesso_xml set fk_id_empresa=1;
update tb_motivo_desoneracao set fk_id_empresa=1;
update tb_modalidade_banco_central_icms_st set fk_id_empresa=1;
update tb_log_atividades set fk_id_empresa=1;
update tb_moeda set fk_id_empresa=1;
update tb_modalidade_banco_central_icms set fk_id_empresa=1;
update tb_ncm set fk_id_empresa=1;
update tb_municipio set fk_id_empresa=1;
update tb_nfe_cupom_fiscal_referenciado set fk_id_empresa=1;
update tb_nfe_destinatario set fk_id_empresa=1;
update tb_nfe_det_especifico_armamento set fk_id_empresa=1;
update tb_nfe_det_especifico_veiculo set fk_id_empresa=1;
update tb_nfe_declaracao_importacao set fk_id_empresa=1;
update tb_nfe_configuracao set fk_id_empresa=1;
update tb_nfe_det_especifico_combustivel set fk_id_empresa=1;
update tb_nfe_cte_referenciado set fk_id_empresa=1;
update tb_nfe_det_especifico_medicamento set fk_id_empresa=1;
update tb_nfe_detalhe_imposto_issqn set fk_id_empresa=1;
update tb_nfe_detalhe_imposto_pis set fk_id_empresa=1;
update tb_nfe_emitente set fk_id_empresa=1;
update tb_nfe_forma_pagamento set fk_id_empresa=1;
update tb_nfe_detalhe_imposto_ii set fk_id_empresa=1;
update tb_nfe_detalhe_imposto_cofins set fk_id_empresa=1;
update tb_nfe_detalhe_imposto_icms set fk_id_empresa=1;
update tb_nfe_detalhe_imposto_ipi set fk_id_empresa=1;
update tb_nfe_duplicata set fk_id_empresa=1;
update tb_nfe_exportacao set fk_id_empresa=1;
update tb_nfe_fatura set fk_id_empresa=1;
update tb_nfe_local_retirada set fk_id_empresa=1;
update tb_nfe_nf_referenciada set fk_id_empresa=1;
update tb_nfe_processo_referenciado set fk_id_empresa=1;
update tb_nfe_prod_rural_referenciada set fk_id_empresa=1;
update tb_nfe_transporte set fk_id_empresa=1;
update tb_nfe_local_entrega set fk_id_empresa=1;
update tb_nfe_numero set fk_id_empresa=1;
update tb_nfe_referenciada set fk_id_empresa=1;
update tb_nota_fiscal_modelo set fk_id_empresa=1;
update tb_operadora_cartao set fk_id_empresa=1;
update tb_orcamento_empresarial set fk_id_empresa=1;
update tb_operadora_plano_saude set fk_id_empresa=1;
update tb_orcamento_fluxo_caixa set fk_id_empresa=1;
update tb_nfe_transporte_volume_lacre set fk_id_empresa=1;
update tb_orcamento_fluxo_caixa_detalhe set fk_id_empresa=1;
update tb_parcelamento set fk_id_empresa=1;
update tb_papel set fk_id_empresa=1;
update tb_pais set fk_id_empresa=1;
update tb_patrim_bem set fk_id_empresa=1;
update tb_orcamento_fluxo_caixa_periodo set fk_id_empresa=1;
update tb_orcamento_periodo set fk_id_empresa=1;
update tb_patrim_depreciacao_bem set fk_id_empresa=1;
update tb_patrim_tipo_aquisicao_bem set fk_id_empresa=1;
update tb_pedido set fk_id_empresa=1;
update tb_pedido_receita set fk_id_empresa=1;
update tb_patrim_indice_atualizacao set fk_id_empresa=1;
update tb_patrim_taxa_depreciacao set fk_id_empresa=1;
update tb_patrim_grupo_bem set fk_id_empresa=1;
update tb_patrim_documento_bem set fk_id_empresa=1;
update tb_patrim_tipo_movimentacao set fk_id_empresa=1;
update tb_pessoa_endereco set fk_id_empresa=1;
update tb_pessoa_telefone set fk_id_empresa=1;
update tb_pessoa_alteracao set fk_id_empresa=1;
update tb_pessoa_fisica set fk_id_empresa=1;
update tb_pessoa_juridica set fk_id_empresa=1;
update tb_pessoa_contato set fk_id_empresa=1;
update tb_plano_conta set fk_id_empresa=1;
update tb_regime_tributario set fk_id_empresa=1;
update tb_pre_venda_cabecalho set fk_id_empresa=1;
update tb_produto_unidade set fk_id_empresa=1;
update tb_receita set fk_id_empresa=1;
update tb_salario_minimo set fk_id_empresa=1;
update tb_plano_natureza_financeira set fk_id_empresa=1;
update tb_salario_familia set fk_id_empresa=1;
update tb_quadro_societario set fk_id_empresa=1;
update tb_sefip_codigo_recolhimento set fk_id_empresa=1;
update tb_simples_nacional set fk_id_empresa=1;
update tb_sefip_codigo_movimentacao set fk_id_empresa=1;
update tb_sefip_categoria_trabalho set fk_id_empresa=1;
update tb_situacao_colaborador set fk_id_empresa=1;
update tb_sindicato set fk_id_empresa=1;
update tb_seguradora set fk_id_empresa=1;
update tb_simples_nacional_cabecalho set fk_id_empresa=1;
update tb_situacao_tributaria_pis set fk_id_empresa=1;
update tb_situacao_tributaria_simples_nacional_icms set fk_id_empresa=1;
update tb_sub_categoria_produto set fk_id_empresa=1;
update tb_socio set fk_id_empresa=1;
update tb_situacao_tributaria_ipi set fk_id_empresa=1;
update tb_situacao_tributaria_icms set fk_id_empresa=1;
update tb_situacao_pedido set fk_id_empresa=1;
update tb_situacao_pagamento set fk_id_empresa=1;
update tb_tipo_desligamento set fk_id_empresa=1;
update tb_tipo_receita_dipi set fk_id_empresa=1;
update tb_tipo_produto_fiscal set fk_id_empresa=1;
update tb_tipo_colaborador set fk_id_empresa=1;
update tb_tabela_preco_produto set fk_id_empresa=1;
update tb_tipo_admissao set fk_id_empresa=1;
update tb_tipo_item_sped set fk_id_empresa=1;
update tb_tipo_receita_dacon set fk_id_empresa=1;
update tb_tipo_relacionamento set fk_id_empresa=1;
update tb_tribut_icms_uf set fk_id_empresa=1;
update tb_tribut_icms_custom_cab set fk_id_empresa=1;
update tb_tribut_icms_custom_det set fk_id_empresa=1;
update tb_tribut_ipi_dipi set fk_id_empresa=1;
update tb_tribut_iss set fk_id_empresa=1;
update tb_transportadora set fk_id_empresa=1;
update tb_tribut_grupo_tributario set fk_id_empresa=1;
update tb_unidade set fk_id_empresa=1;
update tb_venda_romaneio_entrega set fk_id_empresa=1;
update tb_vendedor set fk_id_empresa=1;
update tb_uf set fk_id_empresa=1;
update tb_tribut_pis_cod_apuracao set fk_id_empresa=1;
update tb_venda_orcamento_cabecalho set fk_id_empresa=1;
update tb_banco set fk_id_empresa=1;
update tb_convenio set fk_id_empresa=1;
update tb_cbo set fk_id_empresa=1;
update tb_almoxarifado set fk_id_empresa=1;
update tb_conta_caixa set fk_id_empresa=1;
update tb_dav_detalhe set fk_id_empresa=1;
update tb_produto set fk_id_empresa=1;
update tb_pessoa set fk_id_empresa=1;
update tb_edav_cabecalho set fk_id_empresa=1;
update tb_aliquota_estadual_pe set fk_id_empresa=1;
update tb_estoque_produto set fk_id_empresa=1;
update tb_fin_parcela_receber set fk_id_empresa=1;
update tb_empresa set fk_id_empresa=1;
update tb_usuario set fk_id_empresa=1;
update tb_cod_apuracao_receita_dacon set fk_id_empresa=1;
update tb_compra_cotacao set fk_id_empresa=1;
update tb_agencia_banco set fk_id_empresa=1;
update tb_contabil_lancamento_cabecalho set fk_id_empresa=1;
update tb_compra_cotacao_detalhe set fk_id_empresa=1;
update tb_compra_cotacao_pedido_detalhe set fk_id_empresa=1;
update tb_ecf_r02 set fk_id_empresa=1;
update tb_contabil_lancamento_detalhe set fk_id_empresa=1;
update tb_empresa_transporte_itinerario set fk_id_empresa=1;
update tb_contabil_conta set fk_id_empresa=1;
update tb_efd_tabela_435 set fk_id_empresa=1;
update tb_empresa_telefone set fk_id_empresa=1;
update tb_feriados set fk_id_empresa=1;
update tb_fin_cobranca_parcela_receber set fk_id_empresa=1;
update tb_atividade_for_cli set fk_id_empresa=1;
update tb_natureza_financeira set fk_id_empresa=1;
update tb_fin_lcto_pagar_nt_financeira set fk_id_empresa=1;
update tb_tribut_operacao_fiscal set fk_id_empresa=1;
update tb_grupo_produto set fk_id_empresa=1;
update tb_talonario_cheque set fk_id_empresa=1;
update tb_setor set fk_id_empresa=1;
update tb_nivel_formacao set fk_id_empresa=1;
update tb_plano_conta_ref_sped set fk_id_empresa=1;
update tb_situacao_for_cli set fk_id_empresa=1;
update tb_fin_lcto_receber_nt_financeira set fk_id_empresa=1;
update tb_patrim_estado_conservacao set fk_id_empresa=1;
update tb_financeiro_despesas set fk_id_empresa=1;
update tb_fiscal_inscricoes_substitutas set fk_id_empresa=1;
update tb_nfe_detalhe set fk_id_empresa=1;
update tb_nfe_cana_fornecimento_diario set fk_id_empresa=1;
update tb_patrim_movimentacao_bem set fk_id_empresa=1;
update tb_nota_fiscal_tipo set fk_id_empresa=1;
update tb_fiscal_parametro set fk_id_empresa=1;
update tb_inss_detalhe set fk_id_empresa=1;
update tb_pedido_pagamento set fk_id_empresa=1;
update tb_nfe_transporte_volume set fk_id_empresa=1;
update tb_orcamento_detalhe set fk_id_empresa=1;
update tb_nfe_importacao_detalhe set fk_id_empresa=1;
update tb_socio_dependente set fk_id_empresa=1;
update tb_origem_mercadoria set fk_id_empresa=1;
update tb_papel_funcao set fk_id_empresa=1;
update tb_socio_participacao_societaria set fk_id_empresa=1;
update tb_patrim_apolice_seguro set fk_id_empresa=1;
update tb_nfe_cana_deducoes_safra set fk_id_empresa=1;
update tb_nfe_cabecalho set fk_id_empresa=1;
update tb_nfe_transporte_reboque set fk_id_empresa=1;
update tb_tribut_configura_of_gt set fk_id_empresa=1;
update tb_tabela_preco set fk_id_empresa=1;
update tb_pre_venda_detalhe set fk_id_empresa=1;
update tb_tribut_cofins_cod_apuracao set fk_id_empresa=1;
update tb_produto_receita set fk_id_empresa=1;
update tb_simples_nacional_detalhe set fk_id_empresa=1;
update tb_venda_cabecalho set fk_id_empresa=1;
update tb_tributacao_normal set fk_id_empresa=1;

insert into tb_unidade (id,ativo,data_cadastro,versao,descricao,abreviatura,quantidade,peso_liquido,peso_bruto,medida_liquida,medida_bruta,embalagem	) values (1,true,current_date,0,'UNIDADE 1X1K','UND',1,1,1,'KG','KG','C/1KG'),(758,true,current_date,0,'DUZIA 12X8','DZ ',12,0,0,'KG','KG','DZ'),(47,true,current_date,0,'UNIDADE 1X8','UND',1,0,0,'GR','GR','UND'),(43,true,current_date,0,'PACOTE 15X8','PCT',15,0,0,'KG','KG','15X8'),(105,true,current_date,0,'UNIDADE 1X1','UND',1,0,0,'KG','KG','UND'),(772,true,current_date,0,'PACOTE 6X8UN','PCT',6,0,0,'KG','KG','6X8UN'),(718,true,current_date,0,'DUZIA 12X1','DZ ',12,0,0,'KG','KG','DZ'),(147,true,current_date,0,'CAIXA 24X100ML','CX ',24,2400,2400,'GR','GR','24X100ML'),(404,true,current_date,0,'UNIDADE 1X100ML','UND',1,100,100,'GR','GR','C/100ML'),(5,true,current_date,0,'CAIXA 12X200G','CX ',12,2400,2400,'GR','GR','12X200GR'),(6,true,current_date,0,'UNIDADE 1X200G','UND',1,200,200,'GR','GR','C/200GR'),(87,true,current_date,0,'CAIXA 24X200G','CX ',24,4800,4800,'GR','GR','24X200GR'),(246,true,current_date,0,'CAIXA 24X400G','CX ',24,9600,9600,'GR','GR','24X400GR'),(54,true,current_date,0,'UNIDADE 1X400G','UND',1,400,400,'GR','GR','C/400GR'),(55,true,current_date,0,'CAIXA 16X400G','CX ',16,6400,6400,'GR','GR','16X400GR'),(354,true,current_date,0,'CAIXA 48X200G','CX ',48,9600,9600,'GR','GR','48X200GR'),(650,true,current_date,0,'SACO 50K','SC ',1,50,50,'KG','KG','C/ 50KG'),(2,true,current_date,0,'FARDO 30X1KG','FD ',30,30,30,'KG','KG','C/30X1'),(402,true,current_date,0,'CAIXA 12X100ML','CX ',12,1200,1200,'GR','GR','12X100ML'),(67,true,current_date,0,'GARRAFAO 20LTS','GF ',1,20,20,'KG','KG','C/20LTS'),(136,true,current_date,0,'CAIXA 12X500ML','CX ',12,6,6,'KG','KG','12X500ML'),(143,true,current_date,0,'UNIDADE 1X500ML','UND',1,500,1,'GR','GR','C/500ML'),(41,true,current_date,0,'CAIXA 48X200ML','CX ',48,9600,9600,'GR','GR','48X200ML'),(140,true,current_date,0,'UNIDADE 1X200ML','UND',1,200,200,'GR','GR','C/200ML'),(70,true,current_date,0,'CAIXA 6X2L','CX ',6,12,12,'KG','KG','6X2L'),(300,true,current_date,0,'UNIDADE 1X2L','UND',1,2,2,'KG','KG','C/2L'),(35,true,current_date,0,'CAIXA 12X330ML','CX ',12,3960,3960,'GR','GR','12X330ML'),(37,true,current_date,0,'UNIDADE 1X330ML','UND',1,330,330,'GR','GR','C/330ML'),(38,true,current_date,0,'CAIXA 12X600ML','CX ',12,7200,7200,'GR','GR','12X600ML'),(40,true,current_date,0,'UNIDADE 1X600ML','UND',1,600,600,'GR','GR','C/600ML'),(33,true,current_date,0,'CAIXA 6X1.5L','CX ',6,9,9,'KG','KG','6X1,5L'),(34,true,current_date,0,'UNIDADE 1X1,5L','UND',1,1500,1500,'GR','GR','C/1,5L'),(72,true,current_date,0,'CAIXA 12X1000ML','CX ',12,12,12,'KG','KG','12X1000M'),(74,true,current_date,0,'UNIDADE 1X1000ML','UND',1,1,1,'KG','KG','C/1000ML'),(59,true,current_date,0,'CAIXA 12X1L','CX ',12,12,12,'KG','KG','12X1L'),(303,true,current_date,0,'UNIDADE 1X1L','UND',1,1,1,'KG','KG','C/1L'),(139,true,current_date,0,'CAIXA 12X200ML','CX ',12,2400,2400,'GR','GR','12X200ML'),(75,true,current_date,0,'PACOTE 10X75G','PCT',10,750,750,'GR','GR','10X75G'),(76,true,current_date,0,'UNIDADE 1X75G','UND',1,75,75,'GR','GR','1X75'),(77,true,current_date,0,'PACOTE 10X25G','PCT',10,250,250,'GR','GR','10X25G'),(719,true,current_date,0,'UNIDADE 1X25GR','UND',1,25,25,'GR','GR','C/ 25GR'),(615,true,current_date,0,'CAIXA 12X1','CX ',12,0,0,'KG','KG','C/ 12'),(374,true,current_date,0,'CAIXA 24X500ML','CX ',24,12,12,'KG','KG','24X500ML'),(83,true,current_date,0,'CAIXA 24X150G','CX ',24,3600,3600,'GR','GR','24X150GR'),(82,true,current_date,0,'UNIDADE 1X150G','UND',1,150,150,'GR','GR','C/150GR'),(80,true,current_date,0,'CAIXA 12X150G','CX ',12,1800,1800,'GR','GR','12X150GR'),(93,true,current_date,0,'CAIXA 60X20G','CX ',60,1200,1200,'GR','GR','60X20GR'),(656,true,current_date,0,'UNIDADE 1X60G','UND',1,60,60,'GR','GR','C/60G'),(720,true,current_date,0,'PACOTE C/50UN','PCT',50,0,0,'KG','KG','C/50UN'),(31,true,current_date,0,'FARDO 10X500G','FD ',10,5,5,'KG','KG','10X500GR'),(32,true,current_date,0,'UNIDADE 1X500G','UND',1,500,500,'GR','GR','C/500GR'),(95,true,current_date,0,'UNIDADE 1X20G','UND',1,20,20,'GR','GR','C/20GR'),(96,true,current_date,0,'CAIXA C/120UN','CX.',1,0,0,'KG','KG','C/120 UN'),(97,true,current_date,0,'PACOTE 10X90G','PCT',10,900,900,'GR','GR','10X90GR'),(99,true,current_date,0,'UNIDADE 1X90G','UND',1,90,90,'GR','GR','C/90GR'),(722,true,current_date,0,'CARTELA 20X1','CT ',20,0,0,'GR','KG','C/20'),(470,true,current_date,0,'PACOTE C/04','PCT',1,0,0,'KG','KG','C/04'),(726,true,current_date,0,'CARTELA 12X1','CT ',12,0,0,'KG','KG','C/12'),(721,true,current_date,0,'CARTELA 24X1','CT ',24,0,0,'KG','KG','C/ 24'),(106,true,current_date,0,'ROLO 500MT','RL ',1,0,0,'KG','KG','C/500MT'),(56,true,current_date,0,'CAIXA 50X200G','CX ',50,10,10,'KG','KG','50X200G'),(122,true,current_date,0,'CAIXA 24X170G','CX ',24,4080,4080,'GR','GR','24X170G'),(124,true,current_date,0,'UNIDADE 1X170G','UND',1,170,170,'GR','GR','C/170GR'),(111,true,current_date,0,'CAIXA 24X250G','CX ',24,6,6,'KG','KG','24X250GR'),(232,true,current_date,0,'UNIDADE 1X250G','UND',1,250,250,'GR','GR','C/250GR'),(376,true,current_date,0,'CAIXA 24X200ML','CX ',24,4800,4800,'GR','GR','24X200ML'),(133,true,current_date,0,'CAIXA 24X195ML','CX ',24,4680,4680,'GR','GR','24X195ML'),(135,true,current_date,0,'UNIDADE 1X195ML','UND',1,195,195,'GR','GR','C/195ML'),(141,true,current_date,0,'CAIXA 20X500ML','CX.',20,10,10,'KG','KG','20X500ML'),(144,true,current_date,0,'CAIXA 40X200ML','CX.',40,8,8,'KG','KG','40X200ML'),(307,true,current_date,0,'CAIXA 24X100G','CX ',24,2400,2400,'GR','GR','24X100GR'),(149,true,current_date,0,'UNIDADE 1X100G','UND',1,100,100,'GR','GR','C/100G'),(151,true,current_date,0,'PACOTE 500GR','PCT',1,500,500,'GR','GR','500GR'),(346,true,current_date,0,'CAIXA 12X300ML','CX ',12,3600,3600,'GR','GR','12X300ML'),(673,true,current_date,0,'UNIDADE 1X300ML','UND',1,300,300,'GR','GR','C/ 300ML'),(156,true,current_date,0,'CAIXA 27X200ML','CX ',27,5400,5400,'GR','GR','27X200ML'),(65,true,current_date,0,'CAIXA 20X400G','CX ',20,8,8,'KG','KG','20X400GR'),(66,true,current_date,0,'CAIXA 10X400G','CX ',10,4,4,'KG','KG','10X400'),(674,true,current_date,0,'FARDO 20X400G','FD ',20,8,8,'KG','KG','20X400GR'),(164,true,current_date,0,'CAIXA 30X140G','CX ',30,4200,4200,'GR','GR','30X140GR'),(17,true,current_date,0,'UNIDADE 1X140G','UND',1,140,140,'GR','GR','C/140GR'),(167,true,current_date,0,'CAIXA 45X70G','CX ',45,3150,3150,'GR','GR','45X70GR'),(600,true,current_date,0,'UNIDADE 1X70G','UND',1,70,70,'GR','GR','C/70GR'),(172,true,current_date,0,'FARDO 50X50G','FD ',50,2500,2500,'GR','GR','50X50GR'),(174,true,current_date,0,'UNIDADE 1X50G','UND',1,50,50,'GR','GR','C/50GR'),(175,true,current_date,0,'CAIXA 24X80G','CX ',24,1920,1920,'GR','GR','24X80GR'),(177,true,current_date,0,'UNIDADE 1X80G','UND',1,80,80,'GR','GR','C/80GR'),(181,true,current_date,0,'FARDO 10X1K','FD ',10,10,10,'KG','KG','10X1KG'),(184,true,current_date,0,'CAIXA 30X160G','CX ',30,4800,4800,'GR','GR','30X160GR'),(186,true,current_date,0,'UNIDADE 1X160G','UND',1,160,160,'GR','GR','C/160GR'),(187,true,current_date,0,'CAIXA 30X80G','CX ',30,2400,2400,'GR','GR','30X80GR'),(178,true,current_date,0,'CAIXA 30X130G','CX ',30,3900,3900,'GR','GR','30X130GR'),(180,true,current_date,0,'UNIDADE 1X130G','UND',1,130,130,'GR','GR','C/130GR'),(193,true,current_date,0,'CAIXA 30X58G','CX ',30,1740,1740,'GR','GR','30X58GR'),(195,true,current_date,0,'UNIDADE 1X58G','UND',1,58,58,'GR','GR','C/58GR'),(196,true,current_date,0,'CAIXA 40X135G','CX ',40,5400,5400,'GR','GR','40X135GR'),(198,true,current_date,0,'UNIDADE 1X135G','UND',1,135,135,'GR','GR','C/135GR'),(199,true,current_date,0,'CAIXA 40X62G','CX ',40,2480,2480,'GR','GR','40X62GR'),(201,true,current_date,0,'UNIDADE 1X62G','UND',1,62,62,'GR','GR','C/62GR'),(205,true,current_date,0,'CAIXA 14X400G','CX ',14,5600,5600,'GR','GR','14X400GR'),(207,true,current_date,0,'CAIXA 20X360G','CX ',20,7200,7200,'GR','GR','20X360GR'),(209,true,current_date,0,'UNIDADE 1X360G','UND',1,360,360,'GR','GR','C/360GR'),(210,true,current_date,0,'CAIXA 30X180G','CX ',30,5400,5400,'GR','GR','30X180GR'),(212,true,current_date,0,'UNIDADE 1X180G','UND',1,180,180,'GR','GR','C/180GR'),(222,true,current_date,0,'CAIXA 12X400ML','CX ',12,4800,4800,'GR','GR','12X400ML'),(224,true,current_date,0,'UNIDADE 1X400ML','UND',1,400,400,'GR','GR','C/400ML'),(723,true,current_date,0,'PACOTE 14X8','PCT',14,0,0,'KG','KG','14X8'),(369,true,current_date,0,'CAIXA 10X500G','CX ',10,5,5,'KG','KG','10X500GR'),(230,true,current_date,0,'CAIXA 20X250G','CX ',20,5,5,'KG','KG','20X250GR'),(233,true,current_date,0,'CAIXA 50X100G','CX ',50,5,5,'KG','KG','50X100GR'),(236,true,current_date,0,'CAIXA 24X50G','CX ',24,1200,1200,'GR','GR','24X50GR'),(239,true,current_date,0,'PACOTE 6X65G','PCT',6,390,390,'GR','GR','6X65GR'),(241,true,current_date,0,'UNIDADE 1X65G','UND',1,65,65,'GR','GR','C/65GR'),(579,true,current_date,0,'CAIXA 12X40G','CX ',12,480,480,'GR','GR','12X40GR'),(373,true,current_date,0,'UNIDADE 1X40G','UND',1,40,40,'GR','GR','C/40GR'),(245,true,current_date,0,'CARTELA 2X1','CT ',1,0,0,'KG','KG','C/2'),(247,true,current_date,0,'CAIXA 4X3200G','CX ',4,12800,12800,'GR','GR','4X320GR'),(249,true,current_date,0,'UNIDADE 1X3200G','UN ',1,3200,3200,'GR','GR','C/3200GR'),(107,true,current_date,0,'CAIXA 27X300G','CX.',27,8100,8100,'GR','GR','27X300GR'),(110,true,current_date,0,'UNIDADE 1X300G','UND',1,300,300,'GR','GR','C/300GR'),(251,true,current_date,0,'CAIXA 18X200G','CX ',18,3600,3600,'GR','GR','18X200GR'),(254,true,current_date,0,'CAIXA 18X400G','CX ',18,7200,7200,'GR','GR','18X400GR'),(258,true,current_date,0,'CAIXA 4X3400G','CX ',4,13600,13600,'GR','GR','4X3400GR'),(260,true,current_date,0,'UNIDADE 1X3400G','UND',1,3400,3400,'GR','GR','C/3400GR'),(261,true,current_date,0,'CAIXA 4X3500G','CX ',4,14,14,'KG','KG','4X3500GR'),(263,true,current_date,0,'UNIDADE 1X3500G','UND',1,3500,3500,'GR','GR','C/3500GR'),(250,true,current_date,0,'CAIXA 24X300G','CX ',24,7200,7200,'GR','GR','24X300GR'),(265,true,current_date,0,'CAIXA 36X300G','CX ',36,10800,10800,'GR','GR','36X300GR'),(267,true,current_date,0,'CAIXA 12X830G','CX ',12,9960,9960,'GR','GR','12X830GR'),(269,true,current_date,0,'UNIDADE 1X830G','UND',1,830,830,'GR','GR','C/830GR'),(271,true,current_date,0,'CAIXA 12X850ML','CX ',12,10200,10200,'GR','GR','12X850ML'),(273,true,current_date,0,'UNIDADE 1X850G','UND',1,850,850,'GR','GR','C/850GR'),(274,true,current_date,0,'CAIXA 12X750ML','CX ',12,9,9,'KG','KG','12X750ML'),(276,true,current_date,0,'UNIDADE 1X750ML','UND',1,750,750,'GR','GR','C/750ML'),(52,true,current_date,0,'CAIXA 24X450ML','CX ',24,10800,10800,'GR','GR','24X450ML'),(244,true,current_date,0,'UNIDADE 1X450ML','UN ',1,450,450,'GR','GR','C/450ML'),(171,true,current_date,0,'CAIXA 12X400G','CX ',12,4800,4800,'GR','GR','12X400GR'),(160,true,current_date,0,'CAIXA 20X500G','CX ',20,10,10,'KG','KG','20X500GR'),(128,true,current_date,0,'CAIXA 24X250G','CX ',24,12,12,'KG','KG','24X250GR'),(724,true,current_date,0,'CAIXA C/30KG','CX ',30,1,30,'KG','KG','C/30K'),(585,true,current_date,0,'CAIXA 25X1','CX ',25,0,0,'KG','KG','C/ 25'),(675,true,current_date,0,'CAIXETA','CXT',1,0,0,'KG','KG','CXT'),(536,true,current_date,0,'FARDO 25X200G','FD ',25,5,5,'KG','KG','25X200GR'),(316,true,current_date,0,'CAIXA 12X350ML','CX ',12,4200,4200,'GR','GR','12X350ML'),(298,true,current_date,0,'UNIDADE 1X350ML','UND',1,350,350,'GR','GR','C/350ML'),(301,true,current_date,0,'PACOTE 6X1L','PCT',6,6,6,'KG','KG','6X1L'),(299,true,current_date,0,'PACOTE 6X2L','PCT',6,12,12,'KG','KG','6X2L'),(305,true,current_date,0,'CAIXA 48X50G','CX ',48,240,240,'GR','GR','48X50GR'),(309,true,current_date,0,'CAIXA 10X50G','CX ',10,500,500,'GR','GR','10X50GR'),(727,true,current_date,0,'PACOTE 10X100G','PCT',10,100,1,'GR','KG','10X100GR'),(320,true,current_date,0,'CAIXA 12X480ML','CX ',12,5760,5760,'GR','GR','12X480ML'),(322,true,current_date,0,'UNIDADE 1X480ML','UND',1,480,480,'GR','GR','C/480ML'),(325,true,current_date,0,'CAIXA 20X1','CX ',20,0,0,'KG','KG','20X1'),(324,true,current_date,0,'PACOTE 1X1','PCT',1,0,0,'KG','KG','1X1'),(326,true,current_date,0,'CAIXA 50X1','CX ',50,0,0,'KG','KG','C/50'),(776,true,current_date,0,'PACOTE 10X1','PCT',10,0,0,'KG','KG','C/10'),(331,true,current_date,0,'CAIXA 24X65G','CX ',24,1560,1560,'GR','GR','24X65GR'),(334,true,current_date,0,'FARDO 20X500G','FD ',20,10,10,'KG','KG','20X500G'),(336,true,current_date,0,'CAIXA 27X200G','CX ',27,5400,5400,'GR','GR','27X200GR'),(152,true,current_date,0,'CAIXA 12X300G','CX ',12,3600,3600,'GR','GR','12X300GR'),(562,true,current_date,0,'CAIXA 6X450G','CX ',6,2700,2700,'GR','GR','6X450GR'),(163,true,current_date,0,'UNIDADE 1X450G','UND',1,450,450,'GR','GR','C/450GR'),(351,true,current_date,0,'CAIXA 6X520G','CX ',6,3120,3120,'GR','GR','6X520GR'),(353,true,current_date,0,'UNIDADE 1X520G','UND',1,520,520,'GR','GR','C/520GR'),(127,true,current_date,0,'CAIXA 24X500G','CX ',24,12,12,'KG','KG','24X500GR'),(357,true,current_date,0,'FARDO 30X500G','FD ',30,15,15,'KG','KG','30X500GR'),(363,true,current_date,0,'CAIXA 12X118ML','CX ',12,1416,1416,'GR','GR','12X118ML'),(365,true,current_date,0,'UNIDADE 1X118ML','UND',1,118,118,'GR','GR','C/118ML'),(366,true,current_date,0,'CAIXA 24X90ML','CX ',24,2160,2160,'GR','GR','24X90ML'),(368,true,current_date,0,'UNIDADE 1X90ML','UND',1,90,90,'GR','GR','C/90ML'),(754,true,current_date,0,'DUZIA 12X40G','DZ ',12,40,480,'GR','GR','C/40GR'),(377,true,current_date,0,'CAIXA 12X173ML','CX ',12,2076,2076,'GR','GR','12X173ML'),(379,true,current_date,0,'UNIDADE 1X173ML','UND',1,173,173,'GR','GR','C/173ML'),(380,true,current_date,0,'CAIXA 12X113ML','CX ',12,2076,2076,'GR','GR','12X113ML'),(382,true,current_date,0,'UNIDADE 1X113ML','UND',1,113,113,'GR','GR','C/113ML'),(390,true,current_date,0,'CAIXA 12X105ML','CX ',12,1260,1260,'GR','GR','12X105ML'),(392,true,current_date,0,'UNIDADE 1X105ML','UND',1,105,105,'GR','GR','C/105ML'),(393,true,current_date,0,'CAIXA 12X115ML','CX ',12,1380,1380,'GR','GR','12X115ML'),(395,true,current_date,0,'UNIDADE 1X115ML','UND',1,115,115,'GR','GR','C/115ML'),(396,true,current_date,0,'CAIXA 12X55G','CX ',12,660,660,'GR','GR','12X55GR'),(398,true,current_date,0,'UNIDADE 1X55G','UND',1,55,55,'GR','GR','C/55GR'),(399,true,current_date,0,'CAIXA 12X60ML','CX ',12,720,720,'GR','GR','12X60ML'),(401,true,current_date,0,'UNIDADE 1X60ML','UND',1,60,60,'GR','GR','C/60ML'),(367,true,current_date,0,'CAIXA 12X90ML','CX ',12,1080,1080,'GR','GR','12X90ML'),(405,true,current_date,0,'CAIXA 12X70ML','CX ',12,840,840,'GR','GR','12X70ML'),(407,true,current_date,0,'UNIDADE 1X70ML','UND',1,70,70,'GR','GR','C/70ML'),(773,true,current_date,0,'DUZIA 12X90ML','DZ ',12,1080,1080,'GR','GR','C/ 90ML'),(429,true,current_date,0,'CAIXA 1X7K','CX ',1,7,7,'KG','KG','C/ 7KG'),(417,true,current_date,0,'CAIXA 20X600G','CX ',20,12,12,'KG','KG','20X600GR'),(419,true,current_date,0,'UNIDADE 1X600G','UND',1,600,600,'GR','GR','C/600GR'),(343,true,current_date,0,'CAIXA 4X4.8KG','CX ',4,19200,19200,'GR','GR','4X4,8KG'),(345,true,current_date,0,'UNIDADE 1X4,8KG','UND',1,4800,4800,'GR','GR','C/4,8KG'),(732,true,current_date,0,'PACOTE C/15','PCT',15,0,0,'KG','KG','C/15'),(435,true,current_date,0,'CAIXA 48X10','CX ',48,0,0,'KG','KG','48X10'),(644,true,current_date,0,'UNIDADE 1X10','UND',1,0,0,'KG','KG','1X10'),(438,true,current_date,0,'CAIXA 60X1','CX ',60,0,0,'KG','KG','C/60'),(7,true,current_date,0,'CAIXA 24X190G','CX ',24,4560,4560,'GR','GR','24X190GR'),(9,true,current_date,0,'UNIDADE 1X190G','UND',1,190,190,'GR','GR','C/190GR'),(12,true,current_date,0,'CAIXA 24X350G','CX ',24,8400,8400,'GR','GR','24X350GR'),(14,true,current_date,0,'UNIDADE 1X350G','UND',1,350,350,'GR','GR','C/350GR'),(18,true,current_date,0,'CAIXA 12X860G','CX ',12,10320,10320,'GR','GR','12X860GR'),(20,true,current_date,0,'UNIDADE 1X860G','UND',1,860,860,'GR','GR','C/860GR'),(22,true,current_date,0,'CAIXA 24X260GR','CX ',24,6240,6240,'GR','GR','24X260GR'),(607,true,current_date,0,'UNIDADE 1X260G','UND',1,260,260,'GR','GR','C/260GR'),(21,true,current_date,0,'LATA 1X4.100GR','LT ',1,4100,4100,'GR','GR','C/4.100GR'),(15,true,current_date,0,'CAIXA 48X140G','CX ',48,6720,6720,'GR','GR','48X140GR'),(27,true,current_date,0,'CAIXA 12X850G','CX ',12,10200,10200,'GR','GR','12X850GR'),(24,true,current_date,0,'CAIXA 24X370G','CX.',24,8880,8880,'GR','GR','24X370GR'),(26,true,current_date,0,'UNIDADE 1X370G','UND',1,370,370,'GR','GR','C/370GR'),(445,true,current_date,0,'CAIXA 24X310G','CX ',24,7440,7440,'GR','GR','24X310GR'),(447,true,current_date,0,'UNIDADE 1X310G','UND',1,310,310,'GR','GR','C/310GR'),(448,true,current_date,0,'CAIXA 24X430G','CX ',24,10320,10320,'GR','GR','24X430GR'),(450,true,current_date,0,'UNIDADE 1X430G','UND',1,430,430,'GR','GR','C/430GR'),(454,true,current_date,0,'CAIXA 24X420G','CX ',24,10080,10080,'GR','GR','24X420GR'),(456,true,current_date,0,'UNIDADE 1X420G','UND',1,420,420,'GR','GR','C/420GR'),(457,true,current_date,0,'CAIXA 36X100G','CX ',36,3600,3600,'GR','GR','36X100GR'),(460,true,current_date,0,'CAIXA 24X320G','CX ',24,7680,7680,'GR','GR','24X320GR'),(462,true,current_date,0,'UNIDADE 1X320G','UND',1,320,320,'GR','GR','C/320GR'),(463,true,current_date,0,'CAIXA 24X330G','CX ',24,7920,7920,'GR','GR','24X330GR'),(465,true,current_date,0,'UNIDADE 1X330G','UN ',1,330,330,'GR','GR','C/330GR'),(734,true,current_date,0,'PACOTE C/5 UN','PCT',5,0,0,'KG','KG','C/5UN'),(735,true,current_date,0,'PACOTE C/20','PCT',20,0,0,'KG','KG','C/20'),(736,true,current_date,0,'CAIXETA 15X30G','CXT',15,30,450,'GR','GR','15X30GR'),(599,true,current_date,0,'UNIDADE 1X30G','UND',1,30,30,'GR','GR','C/30GR'),(477,true,current_date,0,'FARDO 12X200G','FD ',12,2400,2400,'GR','GR','12X200GR'),(714,true,current_date,0,'DUZIA 12X90G','DZ ',12,90,1080,'GR','GR','C/ 90GR'),(728,true,current_date,0,'DUZIA 12X50G','DZ ',12,50,600,'GR','GR','C/50GR'),(483,true,current_date,0,'CAIXA 16X600G','CX ',16,9600,9600,'GR','GR','16X600GR'),(485,true,current_date,0,'CAIXA 20X300G','CX ',20,6,6,'KG','KG','20X300GR'),(342,true,current_date,0,'CONJUNTO C/3','CJ ',1,0,0,'KG','KG','C/3'),(729,true,current_date,0,'DUZIA 12X70G','DZ ',12,70,840,'GR','GR','C/70GR'),(730,true,current_date,0,'DUZIA 12X180G','DZ ',12,180,2160,'GR','GR','C/180GR'),(731,true,current_date,0,'DUZIA 12X120G','DZ ',12,120,1440,'GR','GR','C/120GR'),(215,true,current_date,0,'UNIDADE 1X120G','UND',1,120,120,'GR','GR','C/120GR'),(78,true,current_date,0,'CAIXA 24X300G','CX ',24,7200,7200,'GR','GR','24X300GR'),(424,true,current_date,0,'CAIXA 12X700G','CX ',12,8400,8400,'GR','GR','12X700GR'),(426,true,current_date,0,'UNIDADE 1X700G','UND',1,700,700,'GR','GR','C/700GR'),(420,true,current_date,0,'CAIXA 30X300G','CX ',30,9,9,'KG','KG','30X300GR'),(497,true,current_date,0,'CAIXA 24X600G','CX ',24,14400,14400,'GR','GR','24X600GR'),(500,true,current_date,0,'CAIXA 45X80G','CX ',45,3600,3600,'GR','GR','45X80GR'),(237,true,current_date,0,'CAIXA 12X50G','CX ',12,600,600,'GR','GR','12X50GR'),(502,true,current_date,0,'CAIXA 40X50','CX ',40,0,0,'KG','KG','40X50'),(504,true,current_date,0,'UNIDADE 1X50','UND',1,0,0,'KG','KG','1X50'),(506,true,current_date,0,'CAIXA 40X20','CX.',40,0,0,'KG','KG','40X20'),(679,true,current_date,0,'DISPLAY 21X10','DP ',1,0,0,'KG','KG','21X10'),(725,true,current_date,0,'CARTELA 10X1','CT ',10,0,0,'KG','KG','C/10'),(716,true,current_date,0,'CAIXETA 60X6G','CXT',60,6,360,'GR','GR','60X6GR'),(137,true,current_date,0,'CAIXA 6X500G','CX ',6,3,3,'KG','KG','6X500GR'),(516,true,current_date,0,'PACOTE 6X600ML','PC ',6,3600,3600,'GR','GR','6X600ML'),(519,true,current_date,0,'CAIXETA 1X100','CXT',1,0,0,'KG','KG','C/100'),(738,true,current_date,0,'CARTELA 6X10','CT ',6,0,0,'KG','KG','6X10'),(740,true,current_date,0,'CARTELA 20X3','CT ',20,0,0,'KG','KG','20X3'),(707,true,current_date,0,'UNIDADE 1X3','UND',1,0,0,'KG','KG','1X3'),(522,true,current_date,0,'CAIXA 100X1','CX ',100,0,0,'KG','KG','C/100'),(741,true,current_date,0,'CAIXETA 20X30G','CXT',20,600,600,'GR','GR','20X30GR'),(681,true,current_date,0,'DUZIA 12X395G','DZ ',12,4740,4740,'GR','GR','C/395GR'),(528,true,current_date,0,'UNIDADE 1X395G','UND',1,395,395,'GR','GR','C/395GR'),(686,true,current_date,0,'CAIXA 6X1','CX ',6,0,0,'KG','KG','C/ 6'),(529,true,current_date,0,'CAIXA 12X365G','CX ',12,4380,4380,'GR','GR','12X365GR'),(531,true,current_date,0,'UNIDADE 1X365G','UND',1,365,365,'GR','GR','C/365GR'),(532,true,current_date,0,'CAIXA 12X385G','CX ',12,4620,4620,'GR','GR','12X385GR'),(534,true,current_date,0,'UNIDADE 1X385G','UND',1,385,385,'GR','GR','C/385GR'),(535,true,current_date,0,'FARDO 50X200G','FD ',50,10,10,'KG','KG','50X200GR'),(161,true,current_date,0,'CAIXA 24X450G','CX ',24,10800,10800,'GR','GR','24X450GR'),(540,true,current_date,0,'CAIXA 36X230G','CX ',36,8280,8280,'GR','GR','36X230GR'),(542,true,current_date,0,'UNIDADE 1X230G','UND',1,230,230,'GR','GR','C/230GR'),(543,true,current_date,0,'PACOTE C/2.5KG','PCT',1,2500,2500,'GR','GR','C/2.5KG'),(545,true,current_date,0,'KILO','KG ',1,0,0,'KG','KG','KG'),(523,true,current_date,0,'CAIXA 50X85G','CX ',50,4250,4250,'GR','GR','50X85GR'),(482,true,current_date,0,'UNIDADE 1X85G','UND',1,85,85,'GR','GR','C/85GR'),(548,true,current_date,0,'CAIXA 48X85G','CX ',48,4080,4080,'GR','GR','48X85GR'),(550,true,current_date,0,'CAIXA 50X80G','CX ',50,4,4,'KG','KG','50X80GR'),(114,true,current_date,0,'CAIXA 24X196G','CX.',24,4704,4704,'GR','GR','24X196GR'),(116,true,current_date,0,'UNIDADE 1X196G','UND',1,196,196,'GR','GR','C/196GR'),(552,true,current_date,0,'CAIXA 48X250G','CX ',48,12,12,'KG','KG','48X250GR'),(554,true,current_date,0,'BALDE 3K','BD ',1,3,3,'KG','KG','3K'),(89,true,current_date,0,'CAIXA 36X500G','CX ',36,18,18,'KG','KG','36X500GR'),(150,true,current_date,0,'CAIXA 40X500G','CX ',40,20,20,'KG','KG','40X500GR'),(558,true,current_date,0,'CAIXA 12X1K','CX ',12,12,12,'KG','KG','12X1KG'),(624,true,current_date,0,'CAIXA 60X200G','CX ',60,12,12,'KG','KG','60X200GR'),(557,true,current_date,0,'LATA 10K','LT ',1,10,10,'KG','KG','C/ 10KG'),(761,true,current_date,0,'CAIXA 12X500G','CX ',12,6,6,'KG','KG','12X500GR'),(560,true,current_date,0,'LATA 5K','LT ',1,5,5,'KG','KG','C/ 5KG'),(561,true,current_date,0,'BALDE 15K','BD ',1,15,15,'KG','KG','C/ 15KG'),(423,true,current_date,0,'CAIXA 12X450G','CX ',12,5400,5400,'GR','GR','12X450GR'),(563,true,current_date,0,'CAIXA 12X150ML','CX ',12,1800,1800,'GR','GR','12X150ML'),(204,true,current_date,0,'UNIDADE 1X150ML','UND',1,150,150,'GR','GR','C/150ML'),(608,true,current_date,0,'CAIXA 12X520G','CX ',12,6240,6240,'GR','GR','12X520GR'),(119,true,current_date,0,'CAIXA 27X260G','CX.',27,7020,7020,'GR','GR','27X260GR'),(567,true,current_date,0,'CAIXA 24X340G','CX ',24,8160,8160,'GR','GR','24X340GR'),(682,true,current_date,0,'CAIXA 72X40G','CX ',72,2880,2880,'GR','GR','72X40GR'),(683,true,current_date,0,'UNIDADE 1X40','UND',1,0,0,'GR','GR','1X40'),(572,true,current_date,0,'CAIXA 30X400G','CX ',30,12,12,'KG','KG','30X400GR'),(69,true,current_date,0,'CAIXA 6X500ML','CX ',6,3000,3000,'GR','GR','6X500ML'),(574,true,current_date,0,'CAIXA 12X230ML','CX ',12,2760,2760,'GR','GR','12X230ML'),(576,true,current_date,0,'UNIDADE 1X230ML','UND',1,230,230,'GR','GR','C/230ML'),(577,true,current_date,0,'CAIXA 24X60ML','CX ',24,1440,1440,'GR','GR','24X60ML'),(581,true,current_date,0,'CAIXA 20X900ML','CX ',20,1800,1800,'GR','GR','20X900ML'),(583,true,current_date,0,'UNIDADE 1X900ML','UND',1,900,900,'GR','GR','C/900ML'),(439,true,current_date,0,'CAIXA 30X1','CX ',30,0,0,'KG','KG','C/30'),(713,true,current_date,0,'DUZIA 12X75G','DZ ',12,75,900,'GR','GR','C/75GR'),(742,true,current_date,0,'PACOTE C/23','PCT',23,0,0,'KG','KG','C/23'),(743,true,current_date,0,'PACOTE 25X100','PCT',25,0,0,'KG','KG','25X100'),(586,true,current_date,0,'FARDO 10K','FD ',1,10,10,'KG','KG','C/10KG'),(760,true,current_date,0,'FARDO 32X2','FD ',32,0,0,'KG','KG','32X2'),(705,true,current_date,0,'UNIDADE 1X2','UND',1,0,0,'KG','KG','1X2'),(745,true,current_date,0,'FARDO 12X4','FD ',12,0,0,'KG','KG','12X4'),(434,true,current_date,0,'UNIDADE 1X4','UND',1,0,0,'KG','KG','1X4'),(744,true,current_date,0,'FARDO 16X4','FD ',16,0,0,'KG','KG','16X4'),(746,true,current_date,0,'FARDO 24X2','FD ',24,0,0,'KG','KG','24X2'),(747,true,current_date,0,'FARDO 48X1','FD ',48,0,0,'KG','KG','C/48'),(700,true,current_date,0,'FARDO C/04 PCT','FD ',4,0,0,'KG','KG','C/04'),(748,true,current_date,0,'FARDO 12X2','FD ',12,0,0,'KG','KG','12X2'),(416,true,current_date,0,'POTE','PT ',1,0,0,'KG','KG','PT'),(595,true,current_date,0,'PACOTE 1000G','PCT',1,0,0,'KG','KG','C/ 1000GR'),(749,true,current_date,0,'CARTELA 60X1','CT ',60,0,0,'GR','KG','C/60'),(412,true,current_date,0,'CAIXA 12X70G','CX ',12,840,840,'GR','GR','12X70GR'),(610,true,current_date,0,'CAIXA 50X12','CX ',50,0,0,'KG','KG','50X12'),(474,true,current_date,0,'UNIDADE 1X12','UND',1,0,0,'KG','KG','1X12'),(503,true,current_date,0,'CAIXA 20X50','CX ',20,0,0,'KG','KG','20X50'),(553,true,current_date,0,'CAIXA 24X250ML','CX ',24,6,6,'KG','KG','24X250ML'),(315,true,current_date,0,'UNIDADE 1X250ML','UND',1,250,250,'GR','GR','C/250ML'),(750,true,current_date,0,'CAIXETA 12X120G','CXT',12,1440,1440,'GR','GR','12X120GR'),(751,true,current_date,0,'CAIXETA 15X45G','CXT',15,675,675,'GR','GR','15X45GR'),(659,true,current_date,0,'UNIDADE 1X45G','UND',1,45,45,'GR','GR','C/45GR'),(620,true,current_date,0,'CAIXA 56X200G','CX ',56,11200,11200,'GR','GR','56X200GR'),(626,true,current_date,0,'CAIXA 36X200G','CX ',36,7200,7200,'GR','GR','36X200GR'),(687,true,current_date,0,'CONJUNTO','CJ ',1,0,0,'KG','KG','C/5'),(633,true,current_date,0,'CAIXA 12X230G','CX ',12,2760,2760,'GR','GR','12X230GR'),(636,true,current_date,0,'FARDO 24X5','FD ',24,0,0,'KG','KG','24X5'),(638,true,current_date,0,'UNIDADE 1X5','UND',1,0,0,'KG','KG','1X5'),(639,true,current_date,0,'FARDO 24X20G','FD ',24,24,24,'KG','KG','24X20GR'),(642,true,current_date,0,'FARDO 24X10','FD ',24,0,0,'KG','KG','24X10'),(645,true,current_date,0,'FARDO 24X50','FD ',24,0,0,'KG','KG','24X50'),(648,true,current_date,0,'FARDO 24X05','FD ',24,0,0,'KG','KG','24X05'),(355,true,current_date,0,'CAIXA 24X180G','CX ',24,4320,4320,'GR','GR','24X180GR'),(651,true,current_date,0,'PAR','PAR',1,0,0,'KG','KG','PAR'),(652,true,current_date,0,'CAIXA 50X130G','CX ',50,6500,6500,'GR','GR','50X130GR'),(654,true,current_date,0,'CAIXA 48X60G','CX ',48,2880,2880,'GR','GR','48X60GR'),(264,true,current_date,0,'CAIXA 24X300ML','CX ',24,7200,7200,'GR','GR','24X300ML'),(660,true,current_date,0,'CAIXA 16X500G','CX ',16,8,8,'KG','KG','16X500GR'),(688,true,current_date,0,'CAIXA 40X200G','CX ',40,8,8,'KG','KG','40X200GR'),(313,true,current_date,0,'CAIXA 12X250ML','CX ',12,3,3,'KG','KG','12X250ML'),(13,true,current_date,0,'CAIXA 12X350G','CX ',12,4200,4200,'GR','GR','12X350GR'),(752,true,current_date,0,'CAIXETA 24X1','CXT',24,0,0,'KG','KG','C/24UN'),(753,true,current_date,0,'CAIXETA 30X02','CXT',30,0,0,'KG','KG','30X02'),(667,true,current_date,0,'CAIXA 18X750ML','CX ',18,13500,13500,'GR','GR','18X750ML'),(312,true,current_date,0,'PACOTE 10X100G','PCT',1,1,1,'KG','KG','10X100GR'),(63,true,current_date,0,'PACOTE 6X110ML','PCT',6,660,660,'GR','GR','6X110ML'),(64,true,current_date,0,'UNIDADE 1X110ML','KT ',1,110,110,'GR','GR','C/110ML'),(689,true,current_date,0,'PACOTE 12X500ML','PCT',12,6,6,'KG','KG','12X500ML'),(690,true,current_date,0,'PACOTE 6X1,5ML','PCT',6,0,0,'KG','KG','6X1,5ML'),(458,true,current_date,0,'CAIXA 18X100G','CX ',18,1800,1800,'GR','GR','18X100GR'),(691,true,current_date,0,'CAIXA 15X750ML','CX ',15,750,11250,'GR','GR','15X750ML'),(8,true,current_date,0,'CAIXA 12X190G','CX ',12,2280,2280,'GR','GR','12X190GR'),(692,true,current_date,0,'CAIXA 24X230G','CX ',24,230,5520,'GR','GR','24X230GR'),(733,true,current_date,0,'DISPLAY 60X10G','DSP',60,600,600,'GR','GR','60X10GR'),(737,true,current_date,0,'CAIXETA 30X30G','CXT',30,900,900,'GR','GR','30X30GR'),(777,true,current_date,0,'PACOTE 5X8UN','PCT',5,0,0,'KG','KG','C/ 5X8UN'),(112,true,current_date,0,'CAIXA 12X250G','CX.',12,3,3,'KG','KG','12X250GR'),(697,true,current_date,0,'CAIXA 30X175G','CX ',30,175,5250,'GR','GR','30X175GR'),(698,true,current_date,0,'UNIDADE 1X175G','UN ',1,175,175,'GR','GR','C/175GR'),(699,true,current_date,0,'CAIXA 40X40','CX ',40,0,0,'KG','KG','40X40'),(701,true,current_date,0,'FARDO C/08PCT','FD ',8,0,0,'KG','KG','C/8'),(327,true,current_date,0,'PACOTE 10X1','PCT',1,0,0,'KG','KG','C/10'),(717,true,current_date,0,'UNIDADE 1X6G','UND',1,6,6,'GR','GR','C/6GR'),(383,true,current_date,0,'CAIXA 12X90G','CX ',12,1080,1080,'GR','GR','12X90GR'),(739,true,current_date,0,'CARTELA 10X6','CT ',10,0,0,'GR','GR','10X6'),(703,true,current_date,0,'CAIXA 27X395G','CX ',27,395,10665,'GR','GR','27X395GR'),(704,true,current_date,0,'CAIXA 60X120G','CX ',60,120,7200,'GR','GR','60X120GR'),(182,true,current_date,0,'FARDO 5X1K','FD ',5,5,5,'KG','KG','5X1KG'),(706,true,current_date,0,'PACOTE 12X3','PCT',12,0,0,'KG','KG','12X3'),(708,true,current_date,0,'PACOTE 4X250ML','PCT',4,250,1,'GR','KG','4X250ML'),(709,true,current_date,0,'CAIXETA 15X35G','CXT',15,525,525,'GR','GR','15X35GR'),(218,true,current_date,0,'UNIDADE 1X35G','UND',1,35,35,'GR','GR','C/35GR'),(710,true,current_date,0,'CAIXA 120X200G','CX ',120,200,24000,'GR','GR','120X200GR'),(711,true,current_date,0,'CAIXA 24X425G','CX ',24,425,10200,'GR','GR','24X425GR'),(712,true,current_date,0,'UNIDADE 1X425G','UND',1,425,425,'GR','GR','C/425GR'),(774,true,current_date,0,'DUZIA 12X80G','DZ ',12,960,960,'GR','GR','C/ 80GR'),(189,true,current_date,0,'UNIDADE 1X80G','UND',1,80,80,'GR','GR','C/80GR'),(431,true,current_date,0,'PACOTE C/06','PCT',1,0,0,'KG','KG','C/06'),(715,true,current_date,0,'PACOTE C/3','PCT',1,0,0,'KG','KG','C/3'),(60,true,current_date,0,'CAIXA 6 X1L','CX ',6,6,6,'KG','KG','6X1L'),(755,true,current_date,0,'DUZIA 12X35GR','DZ ',12,0,0,'KG','KG','C/35GR'),(231,true,current_date,0,'CAIXA 10X250G','CX ',10,2500,2500,'GR','GR','10X250GR'),(356,true,current_date,0,'PACOTE 1K','PCT',1,1,1,'KG','KG','1K'),(756,true,current_date,0,'PACOTE','PCT',1,0,0,'KG','KG','PCT'),(762,true,current_date,0,'CAIXA 36X60G','CX ',36,2160,2160,'GR','GR','36X60GR'),(190,true,current_date,0,'CAIXA 30X100G','CX ',30,3,3,'KG','KG','30X100GR'),(763,true,current_date,0,'CAIXA 24X270G','CX ',24,6480,6480,'GR','GR','24X270GR'),(764,true,current_date,0,'UNIDADE 1X270G','UN ',1,270,270,'GR','GR','C/270GR'),(605,true,current_date,0,'CAIXA 36X260G','CX ',36,9360,9360,'GR','GR','36X260GR'),(765,true,current_date,0,'CAIXA 12X970ML','CX ',12,11640,11640,'GR','GR','12X970ML'),(766,true,current_date,0,'UNIDADE 1X970ML','UN ',1,970,970,'GR','GR','C/970ML'),(359,true,current_date,0,'UNIDADE 1X500G','UND',1,500,500,'GR','GR','C/500GR'),(570,true,current_date,0,'CAIXA 50X50G','CX ',50,2500,2500,'GR','GR','5X50GR'),(767,true,current_date,0,'CAIXA 30X125G','CX ',30,3750,3750,'GR','GR','30X125GR'),(768,true,current_date,0,'UNIDADE 1X125G','UND',1,125,125,'GR','GR','C/125GR'),(769,true,current_date,0,'PACOTE 6X250ML','PCT',6,1500,1500,'GR','GR','6X250ML'),(770,true,current_date,0,'CAIXA 48X395G','CX ',48,18960,18960,'GR','GR','48X395GR'),(775,true,current_date,0,'CAIXA 6X5K','CX ',6,30,30,'KG','KG','6X5KG'),(544,true,current_date,0,'PACOTE C/5K','PCT',1,5,5,'KG','KG','C/5KG'),(176,true,current_date,0,'CAIXA 12X80G','CX ',12,960,960,'GR','GR','12X80GR'),(778,true,current_date,0,'CAIXA 12X60G','CX ',12,720,720,'GR','GR','12X60GR'),(297,true,current_date,0,'CAIXA 6X350ML','CX ',6,2100,2100,'GR','GR','6X350ML'),(779,true,current_date,0,'CAIXA 30X115G','CX ',30,3450,3450,'GR','GR','30X115GR'),(780,true,current_date,0,'UNIDADE 1X115G','UND',1,115,115,'GR','GR','C/115GR'),(781,true,current_date,0,'CAIXA 60X27G','CX ',60,1620,1620,'GR','GR','60X27GR'),(782,true,current_date,0,'UNIDADE 1X27G','UND',1,27,27,'GR','GR','C/ 27GR'),(3,true,current_date,0,'FARDO 15X1KG','FD ',15,15,15,'KG','KG','15X1KG'),(4,true,current_date,0,'CAIXA 24X200','CX ',24,4800,4800,'GR','GR','24X200GR'),(16,true,current_date,0,'CAIXA 24X140G','CX ',24,3360,3360,'GR','GR','24X140GR'),(19,true,current_date,0,'CAIXA 6X860G','CX ',6,5160,5160,'GR','GR','6X860GR'),(23,true,current_date,0,'CAIXA 12X260G','CX ',12,3120,3120,'GR','GR','12X260GR'),(25,true,current_date,0,'CAIXA 12X370G','CX.',12,4440,4440,'GR','GR','12X370GR'),(28,true,current_date,0,'CAIXA 4X4100G','CX ',4,16400,16400,'GR','GR','4X4100GR'),(29,true,current_date,0,'CAIXA 2X4100G','CX ',2,8200,8200,'GR','GR','2X4100GR'),(36,true,current_date,0,'CAIXA 6X330ML','CX.',6,1980,1980,'GR','GR','6X330ML'),(39,true,current_date,0,'CAIXA 6X600ML','CX ',6,3600,3600,'GR','GR','6X600ML'),(44,true,current_date,0,'CAIXA 48X8','CX ',48,0,0,'KG','KG','48X8'),(46,true,current_date,0,'PACOTE 6X10','PCT',6,0,0,'KG','KG','6X10'),(48,true,current_date,0,'UNIDADE 1X10','UND',1,0,0,'GR','GR','1X10'),(49,true,current_date,0,'CAIXA 24X100','CX ',24,2400,2400,'GR','GR','24X100'),(50,true,current_date,0,'CAIXA 12X100','CX ',12,1100,1100,'GR','GR','12X100'),(51,true,current_date,0,'UNIDADE 1X100','UND',1,100,100,'GR','GR','1X100'),(57,true,current_date,0,'CAIXA 25X200G','CX ',25,5,5,'KG','KG','25X200G'),(61,true,current_date,0,'DUZIA 12X100ML','DZ ',12,1200,1200,'GR','GR','C/100ML'),(62,true,current_date,0,'PACOTE 6X100ML','PCT',6,600,600,'GR','GR','6X100ML'),(68,true,current_date,0,'CAIXA 12X520ML','CX ',12,6240,6240,'GR','GR','12X520ML'),(71,true,current_date,0,'CAIXA 6X2L','CX ',6,12,12,'KG','KG','6X2L'),(73,true,current_date,0,'CAIXA 6X1000ML','CX ',6,6,6,'KG','KG','6X1000ML'),(81,true,current_date,0,'CAIXA 6X150G','CX ',6,900,900,'GR','GR','6X150GR'),(676,true,current_date,0,'PACOTE C/15','PCT',1,0,0,'KG','KG','C/15'),(85,true,current_date,0,'CAIXA 6X200G','CX ',6,1200,1200,'GR','GR','6X200GR'),(677,true,current_date,0,'PACOTE C/20','PCT',1,0,0,'KG','KG','C/20'),(88,true,current_date,0,'PACOTE 750G','PCT',1,750,750,'GR','GR','C/750GR'),(90,true,current_date,0,'CAIXA 18X500G','CX.',18,9,9,'KG','KG','18X500GR'),(94,true,current_date,0,'CAIXA 30X20G','CX.',30,600,600,'GR','GR','30X20GR'),(98,true,current_date,0,'PACOTE 5X90G','PCT',5,450,450,'GR','GR','5X90GR'),(100,true,current_date,0,'CARTELA 24X1','CT ',1,0,0,'KG','KG','C/24'),(101,true,current_date,0,'PACOTE C/4UN','PCT',1,0,0,'KG','KG','C/4UN'),(102,true,current_date,0,'CARTELA 20X1','CT ',1,0,0,'KG','KG','C/20'),(103,true,current_date,0,'CARTELA 12X1','CT ',1,0,0,'KG','KG','C/12'),(108,true,current_date,0,'CAIXA 14X300G','CX ',14,4200,4200,'GR','GR','14X300G'),(109,true,current_date,0,'CAIXA 13X300GR','CX.',13,3900,3900,'GR','GR','13X300GR'),(115,true,current_date,0,'CAIXA 12X196G','CX ',12,2352,2352,'GR','GR','12X196GR'),(117,true,current_date,0,'CAIXA 24X300G','CX.',24,7200,7200,'GR','GR','24X300GR'),(120,true,current_date,0,'CAIXA 14X260G','CX.',14,3640,3640,'GR','GR','14X260GR'),(121,true,current_date,0,'CAIXA 13X260G','CX ',13,3380,3380,'GR','GR','13X260G'),(123,true,current_date,0,'CAIXA 12X170G','CX.',12,2040,2040,'GR','GR','12X170G'),(129,true,current_date,0,'UND.1X500G','UND',1,500,500,'GR','GR','C/500GR'),(130,true,current_date,0,'CAIXA 36X200M','CX ',36,7200,7200,'GR','GR','36X200M'),(131,true,current_date,0,'CAIXA 18X200ML','CX ',18,3600,3600,'GR','GR','18X200ML'),(684,true,current_date,0,'PACOTE C/23','PCT',1,0,0,'KG','KG','C/23'),(134,true,current_date,0,'CAIXA 12X195G','CX ',12,2340,2340,'GR','GR','12X195GR'),(685,true,current_date,0,'FARDO 12X2','FD ',1,0,0,'KG','KG','12X2'),(142,true,current_date,0,'CAIXA 10X500ML','CX ',10,5,5,'KG','KG','10X500ML'),(145,true,current_date,0,'CAIXA 20X200ML','CX.',20,4,4,'KG','KG','20X200ML'),(514,true,current_date,0,'CAIXA 3X500G','CX ',3,1500,1500,'GR','GR','3X500GR'),(148,true,current_date,0,'CAIXA 12X100G','CX ',12,1200,1200,'GR','GR','12X100GR'),(153,true,current_date,0,'CAIXA 6X300G','CX ',6,1800,1800,'GR','GR','6X300GR'),(157,true,current_date,0,'CAIXA 14X200ML','CX ',14,2800,2800,'GR','GR','14X200ML'),(158,true,current_date,0,'CAIXA 13X200ML','CX ',13,2600,2600,'GR','GR','13X200ML'),(162,true,current_date,0,'CAIXA 10X450G','CX ',10,4500,4500,'GR','GR','10X450GR'),(165,true,current_date,0,'CAIXA 15X140G','CX ',15,2100,2100,'GR','GR','15X140GR'),(168,true,current_date,0,'CAIXA 20X70G','CX ',20,1400,1400,'GR','GR','20X70GR'),(169,true,current_date,0,'CAIXA 25X70G','CX ',25,1750,1750,'GR','GR','25X70GR'),(173,true,current_date,0,'FARDO 25X50G','FD ',25,1250,1250,'GR','GR','25X50GR'),(179,true,current_date,0,'CAIXA 15X130G','CX ',15,1950,1950,'GR','GR','15X130GR'),(183,true,current_date,0,'CAIXA 30X140G','CX ',30,4200,4200,'GR','GR','30X140GR'),(185,true,current_date,0,'CAIXA 15X160G','CX ',15,2400,2400,'GR','GR','15X160GR'),(188,true,current_date,0,'CAIXA 15X80G','CX ',15,1200,1200,'GR','GR','15X80GR'),(191,true,current_date,0,'CAIXA 15X100G','CX ',15,1500,1500,'GR','GR','15X100GR'),(693,true,current_date,0,'UNIDADE 1X230G','UND',1,230,230,'GR','GR','C/230GR'),(194,true,current_date,0,'CAIXA 15X58G','CX ',15,870,870,'GR','GR','15X58GR'),(197,true,current_date,0,'CAIXA 20X135G','CX ',20,2700,2700,'GR','GR','20X135GR'),(200,true,current_date,0,'CAIXA 20X62G','CX ',20,1240,1240,'GR','GR','20X62GR'),(202,true,current_date,0,'CAIXA 30X150G','CX ',30,4500,4500,'GR','GR','30X150GR'),(203,true,current_date,0,'CAIXA 15X150G','CX ',15,2250,2250,'GR','GR','15X150GR'),(206,true,current_date,0,'CAIXA 7X400G','CX ',7,2800,2800,'GR','GR','7X400GR'),(208,true,current_date,0,'CAIXA 10X360G','CX ',10,3600,3600,'GR','GR','10X360GR'),(211,true,current_date,0,'CAIXA 15X180G','CX ',15,2700,2700,'GR','GR','15X180GR'),(213,true,current_date,0,'CAIXA 30X120G','CX.',30,3600,3600,'GR','GR','30X120GR'),(214,true,current_date,0,'CAIXA 15X120G','CX ',15,1800,1800,'GR','GR','15X120GR'),(216,true,current_date,0,'CAIXA 36X35G','CX ',36,1260,1260,'GR','GR','36X35GR'),(217,true,current_date,0,'CAIXA 18X35G','CX ',18,630,630,'GR','GR','18X35GR'),(219,true,current_date,0,'CAIXA 24X80G','CX ',24,1920,1920,'GR','GR','24X80GR'),(220,true,current_date,0,'CAIXA 20X140G','CX ',20,2800,2800,'GR','GR','20X140GR'),(221,true,current_date,0,'CAIXA 10X140G','CX ',10,1400,1400,'GR','GR','10X140GR'),(223,true,current_date,0,'CAIXA 6X400ML','CX ',6,2400,2400,'GR','GR','6X400ML'),(225,true,current_date,0,'PACOTE 14X8','PCT',1,0,0,'KG','KG','14X8'),(227,true,current_date,0,'CAIXA 100X10G','CX ',100,1,1,'KG','KG','100X10GR'),(228,true,current_date,0,'CAIXA 50X10G','CX ',50,500,500,'GR','GR','50X10GR'),(229,true,current_date,0,'UNIDADE 1X10G','UND',1,10,10,'GR','GR','C/10GR'),(234,true,current_date,0,'CAIXA 25X100G','CX ',25,2500,2500,'GR','GR','25X100GR'),(240,true,current_date,0,'PACOTE 3X65G','PCT',3,195,195,'GR','GR','3X65GR'),(242,true,current_date,0,'PACOTE 12X40G','PCT',12,480,480,'GR','GR','12X40GR'),(243,true,current_date,0,'PACOTE 6X40G','PCT',6,240,240,'GR','GR','6X40GR'),(248,true,current_date,0,'CAIXA 2X3200G','CX ',2,6400,6400,'GR','GR','2X3200GR'),(252,true,current_date,0,'CAIXA 9X200G','CX ',9,1800,1800,'GR','GR','9X200GR'),(255,true,current_date,0,'CAIXA 9X400G','CX ',9,3600,3600,'GR','GR','9X400GR'),(257,true,current_date,0,'CAIXA 12X180G','CX ',12,2160,2160,'GR','GR','12X180GR'),(259,true,current_date,0,'CAIXA 2X3400G','CX ',2,6800,6800,'GR','GR','2X3400GR'),(262,true,current_date,0,'CAIXA 2X3500G','CX ',2,7,7,'KG','KG','2X3500GR'),(266,true,current_date,0,'CAIXA 18X300G','CX ',18,5400,5400,'GR','GR','18X300GR'),(268,true,current_date,0,'CAIXA 6X830G','CX ',6,4980,4980,'GR','GR','6X830GR'),(272,true,current_date,0,'CAIXA 6X850ML','CX ',6,5100,5100,'GR','GR','6X850ML'),(275,true,current_date,0,'CAIXA 6X750ML','CX ',6,4500,4500,'GR','GR','6X750ML'),(278,true,current_date,0,'CAIXA 12X2','CX ',12,0,0,'KG','KG','12X2'),(279,true,current_date,0,'CAIXA 6X2','CX ',6,0,0,'KG','KG','6X2'),(281,true,current_date,0,'CAIXA 6X400G','CX ',6,2400,2400,'GR','GR','6X400GR'),(282,true,current_date,0,'FARDO 12X500G','FD ',12,6,6,'KG','KG','12X500GR'),(283,true,current_date,0,'FARDO 6X500G','FD ',6,3,3,'KG','KG','6X500GR'),(284,true,current_date,0,'CAIXA 24X10G','CX ',24,240,240,'GR','GR','24X10GR'),(285,true,current_date,0,'CAIXA 12X10G','CX ',12,120,120,'GR','GR','12X10GR'),(286,true,current_date,0,'CAIXA 20X20G','CX ',20,400,400,'GR','GR','20X20GR'),(287,true,current_date,0,'CAIXA 12X20G','CX ',12,240,240,'GR','GR','12X20GR'),(290,true,current_date,0,'CAIXA 25X1K','CX ',25,25,25,'KG','KG','25X1KG'),(291,true,current_date,0,'CAIXA 10X1K','CX ',10,10,10,'KG','KG','10X1KG'),(292,true,current_date,0,'CAIXA 15X1K','CX ',15,15,15,'KG','KG','15X1KG'),(294,true,current_date,0,'FARDO 10X200G','FD ',10,2,2,'KG','KG','10X200GR'),(295,true,current_date,0,'FARDO 15X200G','FD ',15,3,3,'KG','KG','15X200G'),(302,true,current_date,0,'PACOTE 3X1L','PCT',3,3,3,'KG','KG','3X1L'),(304,true,current_date,0,'PACOTE 4X2,5L','PCT',4,10,10,'KG','KG','4X2,5ML'),(310,true,current_date,0,'UNIDADE 1X50G','UND',1,50,50,'GR','GR','C/50GR'),(319,true,current_date,0,'CAIXA 6X200ML','CX ',6,1200,1200,'GR','GR','6X200ML'),(321,true,current_date,0,'CAIXA 6X480ML','CX ',6,2880,2880,'GR','GR','6X480ML'),(328,true,current_date,0,'CAIXA 12X15G','CX ',12,180,180,'GR','GR','12X15GR'),(329,true,current_date,0,'CAIXA 6X15G','CX ',6,90,90,'GR','GR','6X15GR'),(330,true,current_date,0,'UNIDADE 1X15G','UND',1,15,15,'GR','GR','C/15GR'),(332,true,current_date,0,'CAIXA 12X65G','CX ',12,780,780,'GR','GR','12X65GR'),(333,true,current_date,0,'UNIDADE 1X65G','UND',1,65,65,'GR','GR','C/65GR'),(337,true,current_date,0,'CAIXA 14X200G','CX ',14,2800,2800,'GR','GR','14X200GR'),(344,true,current_date,0,'CAIXA 2X4,8KG','CX ',2,9600,9600,'GR','GR','2X4,8KG'),(347,true,current_date,0,'CAIXA 6X250ML','CX ',6,1500,1500,'GR','GR','6X250ML'),(349,true,current_date,0,'CAIXA 3X450G','CX ',3,1350,1350,'GR','GR','3X450GR'),(352,true,current_date,0,'CAIXA 3X520G','CX ',3,1560,1560,'GR','GR','3X520GR'),(358,true,current_date,0,'FARDO 15X500G','FD ',15,7500,7500,'GR','GR','15X500GR'),(360,true,current_date,0,'CAIXA 12X120ML','CX ',12,1440,1440,'GR','GR','12X120ML'),(361,true,current_date,0,'CAIXA 6X120ML','CX ',6,720,720,'GR','GR','6X120ML'),(362,true,current_date,0,'UNIDADE 1X120ML','UND',1,120,120,'GR','GR','C/120ML'),(364,true,current_date,0,'CAIXA 6X118ML','CX ',6,708,708,'GR','GR','6X118ML'),(371,true,current_date,0,'CAIXA 36X40G','CX ',36,1440,1440,'GR','GR','36X40GR'),(372,true,current_date,0,'CAIXA 18X40G','CX ',18,720,720,'GR','GR','18X40GR'),(378,true,current_date,0,'CAIXA 6X173ML','CX ',6,1038,1038,'GR','GR','6X173ML'),(381,true,current_date,0,'CAIXA 6X113ML','CX ',6,678,678,'GR','GR','6X113ML'),(384,true,current_date,0,'CAIXA 12X172ML','CX ',12,2064,2064,'GR','GR','12X172ML'),(385,true,current_date,0,'CAIXA 6X172ML','CX ',6,1032,1032,'GR','GR','6X172ML'),(386,true,current_date,0,'UNIDADE 1X172ML','UND',1,172,172,'GR','GR','C/172ML'),(387,true,current_date,0,'CAIXA 12X103G','CX ',12,1236,1236,'GR','GR','12X103GR'),(388,true,current_date,0,'CAIXA 6X103G','CX ',6,618,618,'GR','GR','6X103GR'),(389,true,current_date,0,'UNIDADE 1X103G','UND',1,103,103,'GR','GR','C/103GR'),(391,true,current_date,0,'CAIXA 6X105ML','CX ',6,630,630,'GR','GR','6X105ML'),(394,true,current_date,0,'CAIXA 6X115ML','CX ',6,690,690,'GR','GR','6X115ML'),(397,true,current_date,0,'CAIXA 6X55G','CX ',6,330,330,'GR','GR','6X55GR'),(400,true,current_date,0,'CAIXA 6X60ML','CX ',6,360,360,'GR','GR','6X60ML'),(403,true,current_date,0,'CAIXA 6X100ML','CX ',6,600,600,'GR','GR','6X100ML'),(406,true,current_date,0,'CAIXA 6X70ML','CX ',6,420,420,'GR','GR','6X70ML'),(408,true,current_date,0,'CAIXA 12X50ML','CX ',12,600,600,'GR','GR','12X50ML'),(409,true,current_date,0,'CAIXA 6X50ML','CX ',6,300,300,'GR','GR','6X50ML'),(410,true,current_date,0,'UNIDADE 1X50ML','UND',1,50,50,'GR','GR','C/50ML'),(411,true,current_date,0,'CAIXA 12X50G','CX ',12,600,600,'GR','GR','12X50GR'),(413,true,current_date,0,'CAIXA 12X49ML','CX ',12,588,588,'GR','GR','12X49ML'),(414,true,current_date,0,'CAIXA 6X49ML','CX ',6,294,294,'GR','GR','6X49ML'),(418,true,current_date,0,'CAIXA 10X600G','CX ',10,6,6,'KG','KG','10X600GR'),(421,true,current_date,0,'CAIXA 15X300G','CX ',15,4500,4500,'GR','GR','15X300GR'),(425,true,current_date,0,'CAIXA 6X700G','CX ',6,4200,4200,'GR','GR','6X700GR'),(427,true,current_date,0,'LATA 390G','LT ',1,390,390,'GR','GR','C/ 390GR'),(428,true,current_date,0,'LATA 800G','LT ',1,800,800,'GR','GR','C/ 800GR'),(430,true,current_date,0,'DISPLAY 21X36G','DP ',1,756,756,'GR','GR','21X36GR'),(432,true,current_date,0,'CAIXA 48X4','CX ',48,0,0,'KG','KG','48X4'),(433,true,current_date,0,'CAIXA 24X4','CX ',24,0,0,'KG','KG','24X4'),(436,true,current_date,0,'CAIXA 24X10','CX ',24,0,0,'KG','KG','24X10'),(440,true,current_date,0,'CAIXA 16X180G','CX ',16,2880,2880,'GR','GR','16X180GR'),(441,true,current_date,0,'CAIXA 8X180G','CX ',8,1400,1440,'GR','GR','8X180GR'),(442,true,current_date,0,'UNIDADE 1X180G','UN ',1,180,180,'GR','GR','C/180GR'),(446,true,current_date,0,'CAIXA 12X310G','CX ',12,3720,3720,'GR','GR','12X310GR'),(449,true,current_date,0,'CAIXA 12X430G','CX ',12,5160,5160,'GR','GR','12X430GR'),(451,true,current_date,0,'CAIXA 24X410G','CX ',24,9840,9840,'GR','GR','24X410GR'),(452,true,current_date,0,'CAIXA 12X410G','CX ',12,4920,4920,'GR','GR','12X410GR'),(453,true,current_date,0,'UNIDADE 1X410G','UND',1,410,410,'GR','GR','C/410GR'),(455,true,current_date,0,'CAIXA 12X420G','CX ',12,5040,5040,'GR','GR','12X420GR'),(459,true,current_date,0,'CAIXA 72X100G','CX ',72,7200,7200,'GR','GR','72X100GR'),(461,true,current_date,0,'CAIXA 12X320G','CX ',12,3840,3840,'GR','GR','12X320GR'),(464,true,current_date,0,'CAIXA 12X330G','CX ',12,3960,3960,'GR','GR','12X330GR'),(466,true,current_date,0,'CAIXA 36X1','CX ',36,0,0,'KG','KG','C/36'),(468,true,current_date,0,'CAIXA 18X1','CX ',18,0,0,'KG','KG','C/18'),(471,true,current_date,0,'PACOTE 6X1','PCT',1,0,0,'KG','KG','C/6'),(472,true,current_date,0,'CAIXA 24X12','CX ',24,0,0,'KG','KG','24X12GR'),(473,true,current_date,0,'CAIXA 12X12','CX ',12,0,0,'KG','KG','12X12'),(478,true,current_date,0,'FARDO 6X200G','FD ',6,1200,1200,'GR','GR','6X200GR'),(479,true,current_date,0,'FARDO 24X200G','FD ',24,4800,4800,'GR','GR','24X200GR'),(480,true,current_date,0,'CAIXA 24X85G','CX ',24,2040,2040,'GR','GR','24X85GR'),(481,true,current_date,0,'CAIXA 12X85G','CX ',12,1020,1020,'GR','GR','12X85GR'),(484,true,current_date,0,'CAIXA 8X600G','CX ',16,9600,9600,'GR','GR','16X600GR'),(486,true,current_date,0,'CAIXA 10X300G','CX ',10,3,3,'KG','KG','10X300GR'),(488,true,current_date,0,'CAIXA 4X5K','CX ',4,20,20,'KG','KG','4X5KG'),(489,true,current_date,0,'CAIXA 2X5K','CX ',2,10,10,'KG','KG','2X5KG'),(490,true,current_date,0,'UNIDADE 1X5K','UND',1,5,5,'KG','KG','C/5KG'),(491,true,current_date,0,'CAIXA 4X4K','CX ',4,16,16,'KG','KG','4X4KG'),(492,true,current_date,0,'CAIXA 2X4K','CX ',2,8,8,'KG','KG','2X4KG'),(493,true,current_date,0,'UNIDADE 1X4K','UND',1,4,4,'KG','KG','C/4KG'),(495,true,current_date,0,'CAIXA 125X40G','CX ',125,5,5,'KG','KG','125X40GR'),(498,true,current_date,0,'CAIXA 12X600G','CX ',12,7200,7200,'GR','GR','12X600GR'),(499,true,current_date,0,'CAIXA 24X130ML','CX ',24,3120,3120,'GR','GR','24X130ML'),(501,true,current_date,0,'UNIDADE 1X80G','UND',1,80,80,'GR','GR','C/80GR'),(505,true,current_date,0,'PACOTE C/05','PCT',1,0,0,'KG','KG','C/05'),(507,true,current_date,0,'CAIXA 20X20','CX ',20,0,0,'KG','KG','20X20'),(509,true,current_date,0,'CAIXA 20X40G','CX ',20,800,800,'GR','GR','20X40GR'),(510,true,current_date,0,'CAIXA 10X40G','CX ',10,400,400,'GR','GR','10X40GR'),(513,true,current_date,0,'CARTELA 1X60','CT ',1,0,0,'KG','KG','C/60'),(517,true,current_date,0,'PACOTE 3X600ML','PCT',3,1800,1800,'GR','GR','3X600ML'),(518,true,current_date,0,'UNIDADE 1X600ML','UND',1,600,600,'GR','GR','C/600ML'),(520,true,current_date,0,'CARTELA 6X10','CT ',1,0,0,'KG','KG','6X10'),(521,true,current_date,0,'CARTELA 20X3','CT ',1,0,0,'KG','KG','20X3'),(526,true,current_date,0,'CAIXA  12X395G','CX ',12,4740,4740,'GR','GR','12X395GR'),(527,true,current_date,0,'CAIXA 6X395G','CX ',6,2370,2370,'GR','GR','6X395GR'),(530,true,current_date,0,'CAIXA 6X365G','CX ',6,2190,2190,'GR','GR','6X365GR'),(533,true,current_date,0,'CAIXA 6X385G','CX ',6,2310,2310,'GR','GR','6X385GR'),(538,true,current_date,0,'CAIXA 25X130G','CX ',25,3250,3250,'GR','GR','25X130GR'),(539,true,current_date,0,'UNIDADE 1X130ML','UND',1,130,130,'GR','GR','C/130ML'),(541,true,current_date,0,'CAIXA 18X230G','CX ',18,4140,4140,'GR','GR','18X230GR'),(546,true,current_date,0,'CAIXA 25X85G','CX ',25,2125,2125,'GR','GR','25X85GR'),(551,true,current_date,0,'CAIXA 25X80G','CX ',25,2,2,'KG','KG','25X80GR'),(556,true,current_date,0,'CAIXA 30X200G','CX ',30,6,6,'KG','KG','30X200GR'),(559,true,current_date,0,'CAIXA 6X1K','CX ',6,6,6,'KG','KG','6X1KG'),(564,true,current_date,0,'CAIXA 6X150ML','CX ',6,900,900,'GR','GR','6X150ML'),(566,true,current_date,0,'CAIXA 12X130ML','CX ',12,1560,1560,'GR','GR','12X130ML'),(568,true,current_date,0,'CAIXA 12X340G','CX ',12,4080,4080,'GR','GR','12X340GR'),(569,true,current_date,0,'UNIDADE 1X340G','UND',1,340,340,'GR','GR','C/340GR'),(571,true,current_date,0,'CAIXA 25X50G','CX ',25,1250,1250,'GR','GR','25X50GR'),(573,true,current_date,0,'CAIXA 15X400G','CX ',15,6,6,'KG','KG','15X400GR'),(575,true,current_date,0,'CAIXA 6X230ML','CX ',6,6,6,'GR','GR','6X230ML'),(578,true,current_date,0,'CAIXA 12X75','CX ',12,900,900,'GR','GR','12X75'),(580,true,current_date,0,'CAIXA 6X40G','CX ',6,240,240,'GR','GR','6X40GR'),(582,true,current_date,0,'CAIXA 10X900ML','CX ',10,9000,9000,'GR','GR','10X900ML'),(594,true,current_date,0,'POTE','PT ',1,0,0,'KG','KG','PT'),(596,true,current_date,0,'CARTELA 2X1','CT ',1,0,0,'KG','KG','C/ 2'),(597,true,current_date,0,'CAIXA 24X30G','CX ',24,720,720,'GR','GR','24X30GR'),(598,true,current_date,0,'CAIXA 12X30G','CX ',12,360,360,'GR','GR','12X30GR'),(601,true,current_date,0,'PACOTE C/50UN','PCT',1,0,0,'KG','KG','C/50UN'),(602,true,current_date,0,'CAIXA 24X110G','CX ',24,2640,2640,'GR','GR','24X110GR'),(603,true,current_date,0,'CAIXA 12X110G','CX ',12,1320,1320,'GR','GR','12X110GR'),(604,true,current_date,0,'UNIDADE 1X110G','UND',1,110,110,'GR','GR','C/110GR'),(606,true,current_date,0,'CAIXA 18X260G','CX ',18,4680,4680,'GR','GR','18X260GR'),(611,true,current_date,0,'CAIXA 25X12','CX ',25,0,0,'KG','KG','25X12'),(613,true,current_date,0,'PACOTE C/4','PCT',1,0,0,'KG','KG','C/4'),(616,true,current_date,0,'CAIXETA 12X120G','CX ',1,1440,1440,'GR','GR','12X120GR'),(618,true,current_date,0,'CAIXETA 12X45G','CXT',1,540,540,'GR','GR','12X45GR'),(621,true,current_date,0,'CAIXA 28X200G','CX ',28,5600,5600,'GR','GR','28X200GR'),(622,true,current_date,0,'CAIXA 100X100G','CX ',100,10,10,'KG','KG','100X100GR'),(623,true,current_date,0,'CAIXA50X100G','CX ',50,5,5,'KG','KG','50X100GR'),(634,true,current_date,0,'CAIXA 6X230G','CX ',6,1380,1380,'GR','GR','6X230GR'),(637,true,current_date,0,'FARDO 12X5','FD ',12,0,0,'KG','KG','12X5'),(640,true,current_date,0,'FARDO 12X20','FD ',12,0,0,'KG','KG','12X20'),(643,true,current_date,0,'FARDO 12X10','FD ',12,0,0,'KG','KG','12X10'),(646,true,current_date,0,'FARDO 12X50','FD ',12,0,0,'KG','KG','12X50'),(649,true,current_date,0,'FARDO 12X05','FD ',12,0,0,'KG','KG','12X05'),(655,true,current_date,0,'CAIXA 24X60G','CX ',24,1440,1440,'GR','GR','24X60GR'),(657,true,current_date,0,'CAIXA 48X45G','CX ',48,2160,2160,'GR','GR','48X45GR'),(658,true,current_date,0,'CAIXA 24X45G','CX ',24,1080,1080,'GR','GR','24X45GR'),(661,true,current_date,0,'CAIXA 8X500G','CX ',8,4,4,'KG','KG','8X500GR'),(668,true,current_date,0,'CAIXA 9X750ML','CX ',9,6750,6750,'GR','GR','9X750ML'),(669,true,current_date,0,'PACOTE C/25UN','PCT',1,0,0,'KG','KG','C/25UN'),(757,true,current_date,0,'CAIXA 24X150ML','CX ',24,150,3600,'GR','GR','24X150ML'),(759,true,current_date,0,'PACOTE C/06','PCT',6,0,0,'KG','KG','C/6'),(771,true,current_date,0,'PACOTE 6X1','PCT',6,0,0,'KG','KG','C/6'),(783,true,current_date,0,'CARTELA 10X5','CT ',10,0,0,'KG','KG','10X5'),(784,true,current_date,0,'UNIDADE 1X850ML','UND',1,850,850,'GR','GR','C/850ML'),(785,true,current_date,0,'CAIXETA 15X25G','CXT',15,375,375,'GR','GR','15X25GR'),(786,true,current_date,0,'PACOTE C/12','PC ',12,0,0,'KG','KG','C/12'),(787,true,current_date,0,'CAIXA 30X50G','CX ',30,1500,1500,'GR','GR','30X50GR'),(788,true,current_date,0,'CAIXA 36X200ML','CX ',36,7200,7200,'GR','GR','36X200ML'),(789,true,current_date,0,'CAIXA 6X250G','CX ',6,0,0,'KG','KG','6X250GR'),(790,true,current_date,0,'CAIXA 06X450GR','CX ',6,2700,2700,'GR','GR','6X450GR'),(791,true,current_date,0,'PACOTE 4X2,5L','PCT',4,0,0,'KG','KG','4X2,5L'),(792,true,current_date,0,'CAIXA 75X60','CX ',1,0,0,'KG','KG','75X60'),(794,true,current_date,0,'UNIDADE 1X4,100KG','UND',1,4100,4100,'KG','KG','C/ 4,100KG'),(793,true,current_date,0,'UNIDADE 1X2,5L','UND',1,0,0,'KG','KG','C/2,5L'),(795,true,current_date,0,'CAIXETA 18X30GR','CXT',18,540,540,'GR','GR','18X30GR'),(796,true,current_date,0,'CAIXETA 20X20GR','CX ',20,40,40,'GR','GR','20X20GR'),(797,true,current_date,0,'DUZIA 12X10','DZ ',12,0,0,'KG','KG','DZ'),(800,true,current_date,0,'CAIXA 24X395G','CX ',24,9480,9480,'GR','GR','24X395GR'),(801,true,current_date,0,'CAIXA 127X1','CX ',127,0,0,'KG','KG','C/ 127UN'),(798,true,current_date,0,'CAIXA 12X950ML','CX ',12,11400,11400,'GR','GR','12X950ML'),(799,true,current_date,0,'CAIXA 24X365G','CX ',24,8760,8760,'GR','GR','24X365GR'),(802,true,current_date,0,'DUZIA 12X365G','DZ.',12,4380,4380,'GR','GR','C/365GR'),(803,true,current_date,0,'DUZIA 12X300G','DZ ',12,3600,3600,'GR','GR','C/300GR'),(804,true,current_date,0,'FARDO 15X2K','FD ',15,30,30,'KG','KG','15X2KG'),(805,true,current_date,0,'UNIDADE 1X2K','UND',1,2,2,'KG','KG','C/ 2KG'),(806,true,current_date,0,'CAIXA 50X90G','CX ',50,4500,4500,'GR','GR','50X90GR'),(807,true,current_date,0,'DUZIA 12X385G','DZ ',12,4620,4620,'GR','GR','C/385GR'),(808,true,current_date,0,'DUZIA 12X36GR','DZ ',12,432,432,'GR','GR','C/ 36GR'),(809,true,current_date,0,'FARDO 20X250G','FD ',20,5,5,'KG','KG','20X250GR'),(810,true,current_date,0,'DUZIA 12X300ML','DZ ',12,3600,3600,'GR','GR','C/ 300ML'),(816,true,current_date,0,'FARDO C/05 PCT','FD ',5,0,0,'KG','KG','C/5PCT'),(811,true,current_date,0,'CAIXETA 8X15G','CXT',8,120,120,'GR','GR','8X15GR'),(812,true,current_date,0,'UNIDADE 1X15G','UND',1,15,15,'GR','GR','C/15GR'),(813,true,current_date,0,'CAIXA 15X900G','CX ',15,13500,13500,'GR','GR','15X900GR'),(814,true,current_date,0,'PACOTE 900G','PCT',1,900,900,'GR','GR','C/900GR'),(815,true,current_date,0,'PEÇA','PC ',1,0,0,'KG','KG','PC'),(817,true,current_date,0,'CAIXA 6X300ML','CX ',6,1800,1800,'GR','GR','6X300ML'),(818,true,current_date,0,'CAIXA 24X290G','CX ',24,6960,6960,'GR','GR','24X290GR'),(819,true,current_date,0,'UNIDADE 1X290G','UND',1,290,290,'GR','GR','C/290GR'),(820,true,current_date,0,'UNIDADE 1X950ML','UND',1,950,950,'GR','GR','C/950ML'),(821,true,current_date,0,'BALDE C/ 10 KG','BDE',1,10,10,'KG','KG','C/ 10KG'),(822,true,current_date,0,'CAIXA 10 KG','CX ',10,10,10,'KG','KG','C/10 KG'),(823,true,current_date,0,'FARDO 6X5K','FD ',6,30,30,'KG','KG','6X5K'),(824,true,current_date,0,'PACOTE 12X240G','PCT',12,2880,2880,'GR','GR','12X240GR'),(825,true,current_date,0,'PACOTE 22X120G','PCT',22,2640,2640,'GR','GR','22X120GR'),(826,true,current_date,0,'CAIXA 27X250ML','CX ',27,6750,6750,'GR','GR','27X250ML'),(827,true,current_date,0,'CAIXA 96X35G','CX ',96,3360,3360,'GR','GR','96X35GR'),(828,true,current_date,0,'FARDO 50X100G','FD ',50,5,5,'KG','KG','50X100GR'),(829,true,current_date,0,'PACOTE C/24','PCT',24,0,0,'KG','KG','C/24'),(831,true,current_date,0,'DUZIA 12X55ML','DZ ',12,660,660,'GR','GR','C/55ML'),(832,true,current_date,0,'UNIDADE 1X55ML','UND',1,55,55,'GR','GR','C/55ML'),(830,true,current_date,0,'PACOTE C/10','PCT',10,0,0,'KG','KG','C/10'),(833,true,current_date,0,'PACOTE 12X250ML','PCT',12,3000,3000,'GR','GR','12X250ML'),(834,true,current_date,0,'CAIXA 30X250G','CX ',30,7500,7500,'GR','GR','30X250GR'),(835,true,current_date,0,'DUZIA 12X85ML','DZ ',12,1020,1020,'GR','GR','C/85ML'),(836,true,current_date,0,'UNIDADE 1X85ML','UND',1,85,85,'GR','KG','C/85ML'),(837,true,current_date,0,'DUZIA 12X30G','DZ ',12,360,360,'GR','GR','C/30GR'),(838,true,current_date,0,'PACOTE 12X50G','PCT',12,600,600,'GR','GR','12X50GR'),(839,true,current_date,0,'PACOTE 12X20G','PCT',12,240,240,'GR','GR','12X20GR'),(840,true,current_date,0,'PACOTE 12X5G','PCT',12,60,60,'GR','GR','12X5GR'),(841,true,current_date,0,'CAIXA 12X900ML','CX ',12,10800,10800,'GR','GR','12X900ML'),(842,true,current_date,0,'CAIXETA 24X10','CXT',24,0,0,'KG','KG','24X10'),(843,true,current_date,0,'CARTELA 1X10','CT ',1,0,0,'KG','KG','C/10'),(991,true,current_date,0,'PACOTE C/10 UN','PCT',1,0,0,'KG','KG','C/10UN'),(844,true,current_date,0,'CAIXA 24X70G','CX ',24,1680,1680,'KG','KG','24X70GR'),(845,true,current_date,0,'CAIXA 24X55G','CX ',24,1320,1320,'GR','GR','24X55GR'),(846,true,current_date,0,'FARDO 60X1','FD ',60,0,0,'KG','KG','C/60'),(847,true,current_date,0,'FARDO 120X1','FD ',120,0,0,'KG','KG','C/120'),(848,true,current_date,0,'UNIDADE 1X36G','UND',1,36,36,'GR','GR','C/36GR'),(849,true,current_date,0,'CAIXA 24X380G','CX ',24,9120,9120,'GR','GR','24X380GR'),(850,true,current_date,0,'UNIDADE 1X380G','UN ',1,380,380,'GR','GR','C/380GR'),(851,true,current_date,0,'CAIXA 24X1','CX ',24,24,24,'GR','GR','C/24'),(852,true,current_date,0,'FARDO C/40','FD ',40,0,0,'KG','KG','C/40'),(853,true,current_date,0,'UNIDADE 1X240G','UND',1,240,240,'GR','GR','C/240GR'),(854,true,current_date,0,'CAIXA 12X360G','CX ',12,4320,4320,'GR','GR','12X360GR'),(855,true,current_date,0,'POTE 1K','PT ',1,1,1,'KG','KG','1KG'),(856,true,current_date,0,'PACOTE 10X250G','PCT',10,2500,2500,'GR','GR','10X250GR'),(857,true,current_date,0,'FARDO 8X8','FD ',8,0,0,'KG','KG','8X8'),(858,true,current_date,0,'FARDO 16X2','FD ',16,0,0,'KG','KG','16X2'),(859,true,current_date,0,'CARTELA 24X1','CT ',20,24,24,'GR','GR','C/24'),(860,true,current_date,0,'DUZIA 12X80ML','DZ ',12,960,960,'GR','GR','C/80ML'),(861,true,current_date,0,'UNIDADE 1X80ML','UND',1,80,80,'GR','GR','C/80ML'),(862,true,current_date,0,'FARDO 6X8','FD ',6,0,0,'KG','KG','6X8'),(863,true,current_date,0,'CONJUNTO C/2','CJ ',2,0,0,'KG','KG','C/2'),(864,true,current_date,0,'CAIXA 50X165G','CX ',50,8250,8250,'GR','GR','50X165GR'),(865,true,current_date,0,'CAIXA 40X180G','CX ',40,7200,7200,'GR','GR','40X180GR'),(866,true,current_date,0,'UNIDADE 1X165G','UND',1,165,165,'GR','GR','C/165GR'),(867,true,current_date,0,'CAIXA 24X35G','CX ',24,24,24,'KG','KG','24X35GR'),(868,true,current_date,0,'UNIDADE 1X35G','UN ',1,1,1,'KG','KG','C/35GR'),(869,true,current_date,0,'CAIXA 60X140G','CX ',60,8400,8400,'GR','GR','60X140GR'),(870,true,current_date,0,'CAIXA 6X3,300KG','CX ',6,19800,19800,'GR','GR','6X3,300GR'),(871,true,current_date,0,'UNIDADE 1X3,300KG','UND',1,3300,3300,'GR','GR','C/3,300KG'),(872,true,current_date,0,'CAIXA 10X1','CX ',10,0,0,'KG','KG','C/10'),(873,true,current_date,0,'CAIXA C/12 PACOTES','CX ',12,0,0,'KG','KG','C/12'),(874,true,current_date,0,'PACOTE 840G','PCT',1,840,840,'GR','GR','C/840GR'),(875,true,current_date,0,'CAIXA 8X150G','CX ',8,1200,1200,'GR','GR','8X150GR'),(876,true,current_date,0,'DUZIA 12X95G','DZ ',12,1,1140,'GR','GR','C/95GR'),(877,true,current_date,0,'UNIDADE 1X95G','UN ',1,1,1,'GR','GR','C/95GR'),(878,true,current_date,0,'PACOTE 12X450ML','PCT',12,5400,5400,'GR','GR','12X450ML'),(879,true,current_date,0,'CAIXETA 24X38G','CX ',24,912,912,'GR','GR','24X38GR'),(881,true,current_date,0,'CAIXETA 30X32G','CXT',30,960,960,'GR','GR','30X32GR'),(992,true,current_date,0,'PACOTE C/8 UN','PCT',1,0,0,'KG','KG','C/8 UN'),(880,true,current_date,0,'UNIDADE 1X38G','UND',1,38,38,'GR','GR','C/38GR'),(882,true,current_date,0,'UNIDADE 1X32G','UND',1,32,32,'GR','GR','C/32GR'),(883,true,current_date,0,'PACOTE C/10K','PCT',1,10,10,'KG','KG','C/10KG'),(884,true,current_date,0,'CAIXA 3X10K','CX ',3,30,30,'KG','KG','3X10KG'),(885,true,current_date,0,'FARDO 40X200G','FD ',40,8,8,'KG','KG','40X200GR'),(886,true,current_date,0,'FARDO 64X1','FD ',64,0,0,'KG','KG','C/64'),(887,true,current_date,0,'CAIXA 48X50','CX ',48,0,0,'GR','GR','48X50'),(888,true,current_date,0,'DUZIA 12X200G','DZ ',12,2400,2400,'GR','GR','C/200GR'),(889,true,current_date,0,'CAIXA 6X3KG','CX ',6,18,18,'KG','KG','6X3KG'),(890,true,current_date,0,'UNIDADE 1X3KG','UN ',1,3,3,'KG','KG','C/3KG'),(891,true,current_date,0,'CAIXA 36X85G','CX ',36,3060,3060,'GR','GR','36X85GR'),(892,true,current_date,0,'CAIXA 50X125G','CX ',50,6250,6250,'GR','GR','50X125GR'),(893,true,current_date,0,'CAIXA 6X2KG','CX ',6,12,12,'KG','KG','6X2KG'),(894,true,current_date,0,'PACOTE 12X250G','PC ',12,3000,300,'GR','GR','12X250GR'),(895,true,current_date,0,'CAIXA 6X300G','CX ',6,18000,18000,'GR','GR','6X3000GR'),(896,true,current_date,0,'CAIXA 6X3000G','CX ',6,18000,18000,'GR','GR','6X3000GR'),(897,true,current_date,0,'CAIXA 24X90G','CX ',24,2160,2160,'GR','GR','24X90GR'),(898,true,current_date,0,'CAIXA 6X2000G','CX ',6,12000,12000,'GR','GR','6X2000GR'),(899,true,current_date,0,'CAIXA 16X100G','CX ',16,1600,1600,'GR','GR','16X100GR'),(900,true,current_date,0,'DUZIA 12X100G','DZ ',12,1200,1200,'GR','GR','C/100G'),(901,true,current_date,0,'PACOTE 12X150G','PCT',12,1800,1800,'GR','GR','12X150GR'),(902,true,current_date,0,'SACO 5KG','SC ',1,5,5,'KG','KG','C/5KG'),(903,true,current_date,0,'CAIXA 12X900G','CX ',12,10800,10800,'GR','GR','12X900GR'),(904,true,current_date,0,'UNIDADE 1X900G','UN ',1,900,900,'GR','GR','C/900GR'),(905,true,current_date,0,'CAIXA 35X160GR','CX ',35,5600,5600,'GR','GR','35X160G'),(906,true,current_date,0,'CAIXA 6X1,8LT','CX ',6,0,0,'KG','KG','6X1,8LT'),(907,true,current_date,0,'CAIXA 9X1,5LT','CX ',9,0,0,'KG','KG','9X1,5LT'),(908,true,current_date,0,'FARDO 8X12','FD ',8,0,0,'GR','GR','8X12'),(909,true,current_date,0,'CAIXA 24X600ML','CX ',24,0,0,'KG','KG','24X600ML'),(910,true,current_date,0,'PACOTE C/02','PCT',2,0,0,'KG','KG','C/02'),(911,true,current_date,0,'PACOTE 12X260ML','PCT',12,0,0,'KG','KG','12X260ML'),(912,true,current_date,0,'UNIDADE 1X260ML','UN ',1,0,0,'KG','KG','C/260ML'),(913,true,current_date,0,'BALDE 2KG','BLD',1,2,2,'KG','KG','C/2KG'),(914,true,current_date,0,'CAIXA C/25KG','CX ',25,0,0,'KG','KG','C/25KG'),(915,true,current_date,0,'FARDO 100X100G','FD ',100,10,10,'KG','KG','100X100GR'),(916,true,current_date,0,'DUZIA 12X250ML','DZ ',12,0,0,'KG','KG','C/250ML'),(918,true,current_date,0,'DUZIA 12X175ML','DZ ',12,0,0,'KG','KG','C/175ML'),(993,true,current_date,0,'PACOTE C/7 UN','PCT',1,0,0,'KG','KG','C/7 UN'),(919,true,current_date,0,'UNIDADE 1X175ML','UN ',1,0,0,'KG','KG','C/175ML'),(917,true,current_date,0,'DUZIA 12X125GR','DZ ',12,0,0,'KG','KG','C/125GR'),(920,true,current_date,0,'CAIXA 12X160ML','CX ',12,0,0,'KG','KG','12X160ML'),(921,true,current_date,0,'UNIDADE 1X160ML','UN ',1,0,0,'KG','KG','C/160ML'),(922,true,current_date,0,'CAIXA 12X105G','CX ',12,0,0,'KG','KG','12X105GR'),(923,true,current_date,0,'PACOTE 6X90ML','PCT',6,0,0,'KG','KG','6X90ML'),(924,true,current_date,0,'UNIDADE 1X105G','UN ',12,0,0,'KG','KG','C/105GR'),(925,true,current_date,0,'PACOTE 6X55ML','PCT',6,0,0,'KG','KG','6X55ML'),(926,true,current_date,0,'UNIDADE 1X105G','UN ',1,0,0,'KG','KG','C/105GR'),(927,true,current_date,0,'CAIXETA 12X200G','CXT',12,0,0,'GR','GR','12X200GR'),(928,true,current_date,0,'CAIXA 20X250ML','CX ',20,0,0,'KG','KG','20X250ML'),(929,true,current_date,0,'CAIXA 6X30ML','CX ',6,0,0,'KG','KG','6X30ML'),(930,true,current_date,0,'UNIDADE 1X30ML','UN ',1,0,0,'KG','KG','C/30ML'),(931,true,current_date,0,'CAIXA 12X58GR','CX ',12,0,0,'KG','KG','12X58GR'),(932,true,current_date,0,'BALDE 1,1KG','BD ',1,0,0,'KG','KG','C/1,1KG'),(933,true,current_date,0,'CARTELA 12X2','CT ',12,0,0,'KG','KG','12X2'),(934,true,current_date,0,'CAIXETA 30X16G','CXT',16,0,0,'KG','KG','30X16GR'),(935,true,current_date,0,'DISPLAY 60X10G','DSP',60,600,600,'GR','GR','60X10GR'),(936,true,current_date,0,'DISPLAY 60X10G','DSP',60,600,600,'GR','GR','60X10GR'),(937,true,current_date,0,'UNIDADE 1X105G','UN ',1,0,0,'KG','KG','C/105GR'),(938,true,current_date,0,'CAIXA 45X45G','CX ',45,0,0,'KG','KG','45X45GR'),(939,true,current_date,0,'UNIDADE 1X45G','UN ',1,0,0,'KG','KG','C/45GR'),(940,true,current_date,0,'CAIXA 40X152G','CX ',40,0,0,'KG','KG','40X152GR'),(941,true,current_date,0,'UNIDADE 1X152G','UN ',1,0,0,'KG','KG','C/152GR'),(942,true,current_date,0,'CAIXA 28X225G','CX ',28,0,0,'KG','KG','28X225GR'),(944,true,current_date,0,'UNIDADE 1X225G','UN ',1,0,0,'KG','KG','C/225GR'),(943,true,current_date,0,'CAIXETA 25X40G','CXT',25,0,0,'KG','KG','25X40GR'),(945,true,current_date,0,'CAIXA C/ 100','CX ',100,0,0,'KG','KG','C/100'),(946,true,current_date,0,'CAIXA C/24 UN','CX ',24,0,0,'KG','KG','C/24UN'),(947,true,current_date,0,'CAIXA 60X2','CX ',60,0,0,'KG','KG','60X2'),(948,true,current_date,0,'CARTELA 4X1','CT ',1,0,0,'KG','KG','C/4'),(949,true,current_date,0,'CAIXA 24X160G','CX ',24,0,0,'KG','KG','24X160GR'),(950,true,current_date,0,'CAIXA 15X700G','CX ',15,10500,10500,'GR','GR','15X700GR'),(951,true,current_date,0,'CAIXA','CX ',1,0,0,'KG','KG','CX'),(952,true,current_date,0,'CONJUNTO C/3','CJ ',3,0,0,'KG','KG','C/3'),(953,true,current_date,0,'CAIXETA 30X16G','CXT',30,0,0,'KG','KG','30X16GR'),(954,true,current_date,0,'PACOTE C/05','PC ',5,0,0,'KG','KG','C/05'),(955,true,current_date,0,'CAIXA C/ 50UN','CX ',50,0,0,'KG','KG','C/50UN'),(956,true,current_date,0,'CAIXA 12X110ML','CX ',12,0,0,'KG','KG','12X110ML'),(957,true,current_date,0,'CAIXA 54X150G','CX ',54,0,0,'KG','KG','54X150GR'),(958,true,current_date,0,'CAIXA 25X200ML','CX ',25,0,0,'KG','KG','25X200ML'),(959,true,current_date,0,'CAIXA 20X300ML','CX ',20,0,0,'KG','KG','20X300ML'),(960,true,current_date,0,'CAIXA 500X10','CX ',500,0,0,'KG','KG','500X10'),(961,true,current_date,0,'CAIXA 250X10','CX ',250,0,0,'KG','KG','250X10'),(962,true,current_date,0,'CAIXA 50X10','CX ',50,0,0,'KG','KG','50X10'),(963,true,current_date,0,'CAIXA 25X10','CX ',25,0,0,'KG','KG','25X10'),(965,true,current_date,0,'CAIXA 12X50','CX ',12,0,0,'KG','KG','12X50'),(964,true,current_date,0,'CAIXETA 50X08G','CXT',50,0,0,'KG','KG','50X08GR'),(966,true,current_date,0,'CAIXA 20X700G','CX ',20,0,0,'KG','KG','20X700GR'),(967,true,current_date,0,'CAIXA 20X350G','CX ',20,0,0,'KG','KG','20X350GR'),(968,true,current_date,0,'SACO','SC ',1,0,0,'KG','KG','SC'),(969,true,current_date,0,'CAIXA 36X100ML','CX ',36,0,0,'KG','KG','36X100ML'),(970,true,current_date,0,'DISPLAY 30X16G','DP ',1,480,480,'GR','GR','30X16GR'),(971,true,current_date,0,'DISPLAY 30X16G','DP ',30,480,480,'GR','GR','30X16GR'),(972,true,current_date,0,'CAIXA 20X330G','CX ',20,0,0,'KG','KG','20X330GR'),(973,true,current_date,0,'CAIXA 30X55G','CX ',30,0,0,'KG','KG','30X55GR'),(974,true,current_date,0,'CAIXA 8X400G','CX ',8,0,0,'KG','KG','8X400GR'),(975,true,current_date,0,'PACOTE C/100','PCT',1,0,0,'KG','KG','C/100'),(976,true,current_date,0,'PACOTE C/100','PCT',100,0,0,'KG','KG','C/100'),(977,true,current_date,0,'LATA 1X100G','LT ',1,100,100,'GR','GR','C/100GR'),(978,true,current_date,0,'CAIXA 24X6','CX ',6,0,0,'KG','KG','24X6X10'),(979,true,current_date,0,'CAIXA 96X25G','CX ',96,0,0,'KG','KG','96X25GR'),(982,true,current_date,0,'PACOTE C/06 PARES','PCT',6,0,0,'KG','KG','C/06'),(984,true,current_date,0,'FARDO 25X400G','FD ',25,0,0,'KG','KG','25X400GR'),(983,true,current_date,0,'CAIXA 25X400G','CX ',25,0,0,'KG','KG','25X400GR'),(985,true,current_date,0,'KILO (10X100G)','KG ',10,1,1,'KG','KG','10X100GR'),(986,true,current_date,0,'KILO (4X250G)','KG ',4,1,1,'KG','KG','4X250GR'),(987,true,current_date,0,'CAIXA 8X20X30G','CX ',8,0,0,'KG','KG','8X20X30GR'),(988,true,current_date,0,'CAIXA 12X130GR','CX ',12,1560,1560,'GR','GR','12X130GR'),(989,true,current_date,0,'CAIXA 12X210GR','CX ',12,2520,2520,'GR','GR','12X210GR'),(994,true,current_date,0,'DUZIA 12X53GR','DZ ',12,636,636,'GR','GR','C/53GR'),(995,true,current_date,0,'PACOTE 12X237ML','PCT',12,0,0,'KG','KG','12X237M'),(990,true,current_date,0,'KILO (20X50G)','KG ',20,1,1,'KG','KG','20X50GR'),(996,true,current_date,0,'UNIDADE 1X237ML','UN ',1,0,0,'KG','KG','C/237ML'),(997,true,current_date,0,'CAIXETA 24X40G','CXT',24,0,0,'KG','KG','24X40G'),(998,true,current_date,0,'CAIXETA 30X33G','CXT',30,0,0,'KG','KG','30X33G'),(999,true,current_date,0,'CAIXETA 14X40G','CXT',14,0,0,'KG','KG','14X40G'),(1000,true,current_date,0,'CAIXETA 6X30G','CXT',6,0,0,'KG','KG','6X30G'),(1001,true,current_date,0,'CAIXETA 6X25G','CXT',6,0,0,'KG','KG','6X25G'),(1002,true,current_date,0,'CAIXETA 6X27G','CXT',6,0,0,'KG','KG','6X27G'),(1003,true,current_date,0,'CAIXETA 6X24G','CXT',6,0,0,'KG','KG','6X24G'),(1004,true,current_date,0,'UNIDADE','UN ',6,0,0,'KG','KG','C/6'),(1005,true,current_date,0,'PACOTE C/40','PCT',40,0,0,'KG','KG','C/40'),(1006,true,current_date,0,'CAIXA 12 (20X25G)','CX ',240,0,0,'KG','KG','12 (20X25G)'),(1007,true,current_date,0,'DUZIA 12X60ML','DZ ',12,0,0,'KG','KG','C/60ML'),(1008,true,current_date,0,'CAIXETA 12X30ML','CXT',12,0,0,'KG','KG','12X30ML'),(1009,true,current_date,0,'DUZIA 12X380GR','DZ ',12,4560,4560,'GR','GR','C/380GR'),(1010,true,current_date,0,'CAIXA 27X500GR','CX ',27,13500,13500,'GR','GR','27X500GR'),(1011,true,current_date,0,'CAIXA 24X315GR','CX ',24,7560,7560,'GR','GR','24X315GR'),(1012,true,current_date,0,'UNIDADE 1X315GR','UND',1,315,315,'GR','GR','C/ 315GR'),(1013,true,current_date,0,'CAIXA 10X460GR','CX ',10,4600,4600,'GR','GR','10X460GR'),(1014,true,current_date,0,'UNIDADE 1X460GR','UND',1,460,460,'GR','GR','C/ 460GR'),(1015,true,current_date,0,'FARDO 20X200GR','FD ',20,4000,4000,'GR','GR','20X200GR'),(1016,true,current_date,0,'PACOTE 6X85G','PC ',6,510,510,'GR','GR','6X85G'),(1017,true,current_date,0,'CAIXA 30X90GR','CX ',30,2700,2700,'GR','GR','30X90GR'),(1018,true,current_date,0,'BALDE 4,6KG','BLD',1,4600,4600,'GR','GR','4,6KG'),(1019,true,current_date,0,'DUZIA 12X500GR','DZ ',12,6000,6000,'GR','GR','12X500GR'),(1020,true,current_date,0,'CAIXA 50X70GR','CX ',50,3500,3500,'GR','GR','50X70GR'),(1021,true,current_date,0,'CAIXA 50X74GR','CX ',50,3700,3700,'GR','GR','50X74GR'),(1022,true,current_date,0,'UNIDADE 1X74GR','UND',1,74,74,'GR','GR','C/ 74GR'),(1023,true,current_date,0,'CAIXA 20X18','CX ',20,0,0,'KG','KG','20X18'),(1024,true,current_date,0,'UNIDADE 1X18','UND',1,1,1,'KG','KG','1X18'),(1026,true,current_date,0,'CAIXETA 10X63GR','CXT',10,630,630,'GR','GR','10X63GR'),(1027,true,current_date,0,'UNIDADE 1X63GR','UND',1,63,63,'GR','GR','C/ 63GR'),(1028,true,current_date,0,'CAIXETA 15X24GR','CXT',15,360,360,'GR','GR','15X24GR'),(1025,true,current_date,0,'CAIXETA 10X63GR','CXT',1,630,630,'GR','GR','10X63GR'),(1029,true,current_date,0,'UNIDADE 1X24GR','UND',1,24,24,'GR','GR','C/ 24GR'),(1030,true,current_date,0,'PACOTE 12X1L','PCT',12,1,1,'KG','KG','12X1L'),(1032,true,current_date,0,'PACOTE 14X6','PCT',14,0,0,'KG','KG','14X6'),(1033,true,current_date,0,'UNIDADE','UND',1,0,0,'GR','GR','UND'),(1034,true,current_date,0,'CAIXA 24X360G','CX ',24,8640,8640,'GR','GR','24X360'),(1035,true,current_date,0,'CAIXA 24X520G','CX ',24,12480,12480,'GR','GR','24X520'),(1036,true,current_date,0,'DISPLAY','DP ',1,0,0,'KG','KG','1X1'),(1037,true,current_date,0,'CAIXETA 20X25G','CXT',20,500,500,'GR','GR','20X25G'),(1038,true,current_date,0,'CAIXETA 20X24G','CXT',20,480,480,'GR','GR','20X24G'),(1039,true,current_date,0,'CAIXETA 20X27G','CXT',20,540,540,'GR','GR','20X27G'),(1040,true,current_date,0,'CAIXA 25X125GR','CX ',25,3125,3125,'GR','GR','25X125GR'),(1041,true,current_date,0,'DUZIA 12X130GGR','DZ ',12,1560,1560,'GR','GR','130GR'),(1043,true,current_date,0,'PACOTE C/10KG','PCT',1,10,10,'KG','KG','C/10KG'),(1042,true,current_date,0,'CAIXA 3X10KG','CX ',3,30,30,'KG','KG','3X10KG'),(1044,true,current_date,0,'DUZIA 12X168ML','DZ ',12,1200,1200,'GR','GR','168ML'),(1045,true,current_date,0,'UNIDADE 1X163ML','UN ',1,100,100,'GR','GR','C/ 163ML'),(1046,true,current_date,0,'DUZIA 12X50ML','DZ ',12,1,1,'KG','KG','C/ 50ML'),(1047,true,current_date,0,'CAIXA 20X325G','CX ',20,6500,6500,'GR','GR','20X325G'),(1048,true,current_date,0,'UNIDADE 1X325G','UN ',1,325,325,'GR','GR','1X325G'),(1049,true,current_date,0,'PECA C/ 3,250KG','PC ',1,3250,3250,'GR','GR','C/ 3,250'),(1050,true,current_date,0,'CAIXA 40X50G','CX ',40,2000,2000,'GR','GR','40X50G'),(1051,true,current_date,0,'CAIXA 35X30G','CX ',35,1050,1050,'GR','GR','35X30G'),(1052,true,current_date,0,'CAIXA 36X30G','CX ',36,1080,1080,'GR','GR','36X30G'),(1053,true,current_date,0,'CAIXA 48X2','CX ',48,0,0,'KG','KG','48X2'),(1054,true,current_date,0,'CAIXETA 10X57G','CXT',10,570,570,'GR','GR','10X57G'),(1055,true,current_date,0,'FARDO C/80','FD ',80,0,0,'KG','KG','C/ 80'),(1056,true,current_date,0,'CAIXA 12X215ML','CX ',12,2580,12,'GR','GR','12X215ML'),(1057,true,current_date,0,'UNIDADE 1X215ML','UND',1,215,215,'GR','GR','1X215ML'),(1058,true,current_date,0,'CAIXETA C/10','CXT',10,570,570,'GR','GR','C/10'),(1059,true,current_date,0,'CAIXA 100X200G','CX ',100,20000,20000,'GR','GR','100X200G'),(1060,true,current_date,0,'CAIXA 50X88G','CX ',50,4400,4400,'GR','GR','50X88G'),(1061,true,current_date,0,'CAIXA 24X385G','CX ',24,9240,9240,'GR','GR','24X385G'),(1062,true,current_date,0,'CAIXA 24X390G','CX ',24,9360,9360,'GR','GR','24X390G'),(1063,true,current_date,0,'UNIDADE 1X390G','UND',1,390,390,'GR','GR','1X390G'),(1064,true,current_date,0,'PACOTE 14X4','PCT',14,56,56,'GR','GR','14X4'),(1065,true,current_date,0,'CAIXETA 12X40G','CXT',12,480,480,'GR','GR','12X40G'),(1066,true,current_date,0,'CAIXA 50X30G','CX ',50,1500,1500,'GR','GR','50X30G'),(1067,true,current_date,0,'CAIXA 12X472G','CX ',12,5664,5664,'GR','GR','12X472G'),(1068,true,current_date,0,'UNIDADE 1X472G','UND',1,472,472,'GR','GR','1X472G'),(1069,true,current_date,0,'FARDO 12X300G','FD ',12,3600,3600,'GR','GR','12X300G'),(1070,true,current_date,0,'CAIXETA 192X8G','CXT',192,1536,1536,'GR','GR','192X8G'),(1071,true,current_date,0,'CAIXETA 192X7G','CXT',192,1344,1344,'GR','GR','192X7G'),(1072,true,current_date,0,'CAIXETA 20X100G','CXT',20,2000,2000,'GR','GR','20X100G'),(1073,true,current_date,0,'CAIXETA 12X25G','CXT',12,300,300,'GR','GR','12X25G'),(1074,true,current_date,0,'FARDO C/25 PCT','FD ',25,0,0,'KG','KG','C/25 PCT'),(1075,true,current_date,0,'CAIXETA 190X7G','CXT',190,1330,1330,'GR','GR','190X7G'),(1076,true,current_date,0,'CAIXA 48X56G','CX ',48,2688,2688,'GR','GR','48X56G'),(1077,true,current_date,0,'UNIDADE 1X56G','UND',1,56,56,'GR','GR','56G'),(1078,true,current_date,0,'PACOTE 10X100','PCT',10,0,0,'KG','KG','10X100'),(1079,true,current_date,0,'CAIXA 30X110G','CX ',30,0,0,'KG','KG','30X110G'),(1080,true,current_date,0,'CAIXA 40X140G','CX ',40,0,0,'KG','KG','40X140G'),(1081,true,current_date,0,'CAIXA 40X130G','CX ',40,0,0,'KG','KG','40X130G'),(1082,true,current_date,0,'CAIXA 10X350G','CX ',10,0,0,'KG','KG','10X350G'),(1083,true,current_date,0,'CAIXA 10X325G','CX ',10,0,0,'KG','KG','10X325G'),(1084,true,current_date,0,'CAIXA 12X64G','CX ',12,0,0,'KG','KG','12X64G'),(1085,true,current_date,0,'UNIDADE 1X64G','UN ',1,64,0,'KG','KG','1X64G'),(1086,true,current_date,0,'CAIXA 12X1L','CX ',12,0,0,'KG','KG','12X1L'),(1087,true,current_date,0,'CAIXA 22X200G','CX ',22,0,0,'KG','KG','22X200G'),(1088,true,current_date,0,'CAIXA 50X63G','CX ',50,0,0,'KG','KG','50X63G'),(1089,true,current_date,0,'FARDO 40X250G','FD ',40,10000,10000,'GR','GR','40X250R'),(1090,true,current_date,0,'CAIXA 36X180G','CX ',36,0,0,'KG','KG','36X180G'),(1091,true,current_date,0,'CAIXETA 24X35G','CXT',24,0,0,'KG','KG','24X35'),(1092,true,current_date,0,'DUZIA 12X370G','DZ ',12,0,0,'KG','KG','12X370G'),(1093,true,current_date,0,'CAIXA 40X120G','CX ',40,0,0,'KG','KG','40X120G'),(1094,true,current_date,0,'CAIXETA 12X65G','CXT',12,0,0,'KG','KG','12X65G'),(1095,true,current_date,0,'CAIXETA 10X45G','CXT',10,0,0,'KG','KG','10X45G'),(1096,true,current_date,0,'FARDO 5X2K','FD ',5,0,0,'KG','KG','5X2K'),(1097,true,current_date,0,'FARDO 24X500G','FD ',24,0,0,'KG','KG','24X500G'),(1098,true,current_date,0,'CAIXA 54X12','CX ',54,0,0,'KG','KG','54X12'),(1099,true,current_date,0,'DUZIA','DZ ',1,0,0,'KG','KG','DZ'),(1100,true,current_date,0,'CARTELA 14X1','CT ',14,0,0,'KG','KG','14X1'),(1101,true,current_date,0,'CAIXA 30X135G','CX ',30,0,0,'KG','KG','30X135G'),(1102,true,current_date,0,'CONJUNTO C/6','CJ ',6,0,0,'KG','KG','C/6'),(1103,true,current_date,0,'CAIXA 20X420G','CX ',20,0,0,'KG','KG','20X420G'),(1104,true,current_date,0,'PACOTE 6X200MT','PC ',6,0,0,'KG','KG','6X200MT'),(1105,true,current_date,0,'PACOTE 6X150MT','PC ',6,0,0,'KG','KG','6X150MT'),(1106,true,current_date,0,'UNIDADE 1X200MT','UN ',1,0,0,'KG','KG','1X200MT'),(1107,true,current_date,0,'UNIDADE 1X150MT','UN ',1,0,0,'KG','KG','1X150MT'),(1108,true,current_date,0,'CAIXA 12X4','CX ',12,0,0,'KG','KG','12X4'),(1109,true,current_date,0,'CAIXA C/6 DZ','CX ',6,0,0,'KG','KG','C/6 DZ'),(1110,true,current_date,0,'CAIXA 6X12','CX ',72,0,0,'KG','KG','6X12'),(1111,true,current_date,0,'CAIXA 9X12X90G','CX ',108,0,0,'KG','KG','9X12X90G'),(1112,true,current_date,0,'CAIXA 4X12X75G','CX ',48,0,0,'KG','KG','4X12X75G'),(1113,true,current_date,0,'PACOTE 12X900ML','PC ',12,0,0,'KG','KG','12X900ML'),(1114,true,current_date,0,'CAIXA 24X20G','CX ',24,0,0,'KG','KG','24X20G'),(1115,true,current_date,0,'CAIXA 27X250GR','CX ',27,6750,6750,'GR','GR','27X250GR'),(1117,true,current_date,0,'UNIDADE 1X32G','UN ',1,0,0,'KG','KG','1X32G'),(1116,true,current_date,0,'CAIXA 48X32G','CX ',48,0,0,'KG','KG','48X32G'),(1119,true,current_date,0,'CAIXA 50X100UN','CX ',50,0,0,'KG','KG','50X100UN'),(1118,true,current_date,0,'CAIXA 4X12X90GR','CX ',48,0,0,'KG','KG','4X12X90G'),(1120,true,current_date,0,'CAIXA 6X12X130G','CX ',72,0,0,'KG','KG','6X12X130G'),(1121,true,current_date,0,'CAIXA 24X8X8G','CX ',24,1536,1536,'GR','GR','24X8'),(1123,true,current_date,0,'CAIXA 12X240G','CX ',12,0,0,'KG','KG','12X240G'),(1122,true,current_date,0,'CAIXA 8X12X90G','CX ',96,0,0,'KG','KG','8X12X90G'),(1124,true,current_date,0,'DUZIA 12X60G','DZ ',12,0,0,'KG','KG','12X60G'),(1125,true,current_date,0,'CAIXA 10X800G','CX ',10,0,0,'KG','KG','10X800G'),(1126,true,current_date,0,'FARDO 5X5X40','FD ',5,0,0,'KG','KG','5X5X40'),(1127,true,current_date,0,'CAIXA 12X800G','CX ',12,0,0,'KG','KG','12X800G'),(1128,true,current_date,0,'PACOTE 5X40','PC ',1,0,0,'KG','KG','5X40'),(1129,true,current_date,0,'CAIXA 6X950G','CX ',6,0,0,'KG','KG','6X950G'),(1130,true,current_date,0,'FARDO 10X800G','FD ',10,0,0,'KG','KG','10X800G'),(1131,true,current_date,0,'UNIDADE 1X800G','UN ',1,0,0,'KG','KG','1X800G'),(1132,true,current_date,0,'UNIDADE 1X950G','UN ',1,0,0,'KG','KG','1X950G'),(1133,true,current_date,0,'METRO','MT ',1,0,0,'KG','KG','MT'),(1134,true,current_date,0,'CAIXA 36X140G','CX ',36,0,0,'KG','KG','36X140G'),(1135,true,current_date,0,'CARTELA 20X5','CT ',20,0,0,'KG','KG','20X5'),(1136,true,current_date,0,'CARTELA 10X4','CT ',10,0,0,'KG','KG','10X4'),(1137,true,current_date,0,'CAIXA 42X200G','CX ',42,0,0,'KG','KG','42X200G'),(1138,true,current_date,0,'CAIXA 40X110G','CX ',40,4400,4400,'GR','GR','40X110'),(1139,true,current_date,0,'CAIXA 36X290ML','CX ',36,0,0,'KG','KG','36X290ML'),(1140,true,current_date,0,'CARTELA C/06','CT ',6,0,0,'KG','KG','C/06'),(1141,true,current_date,0,'CAIXETA 30X10G','CXT',30,300,300,'GR','GR','30X10'),(1142,true,current_date,0,'CAIXETA 10X10G','CXT',10,0,0,'KG','KG','10X10G'),(1143,true,current_date,0,'CAIXETA 10X15G','CXT',10,0,0,'KG','KG','10X15'),(1144,true,current_date,0,'CAIXA 12X880G','CX ',12,0,0,'KG','KG','12X880G'),(1145,true,current_date,0,'LATA 880G','LT ',1,0,0,'KG','KG','880G'),(1146,true,current_date,0,'CAIXA 4X4,1KG','CX ',4,0,0,'KG','KG','4X4,1'),(1147,true,current_date,0,'CAIXA 36X340G','CX ',36,0,0,'KG','KG','36X340'),(1148,true,current_date,0,'CAIXA 36X350G','CX ',36,12600,12600,'GR','GR','36X350'),(1149,true,current_date,0,'CAIXA 32X500G','CX ',32,0,0,'KG','KG','32X500'),(1150,true,current_date,0,'CAIXA 06X4KG','CX ',6,0,0,'KG','KG','06X4KG'),(1151,true,current_date,0,'CAIXA 96X150ML','CX ',96,0,0,'KG','KG','96X150'),(1152,true,current_date,0,'CAIXA 10X1000ML','CX ',10,0,0,'KG','KG','10X1000ML'),(1153,true,current_date,0,'CAIXA 20X200G','CX ',20,0,0,'KG','KG','20X200G'),(1154,true,current_date,0,'CAIXA 6X2800KG','CX ',6,17,0,'KG','KG','6X2800KG'),(1155,true,current_date,0,'CAIXA 4X1700KG','CX ',4,0,0,'KG','KG','4X1700KG'),(1156,true,current_date,0,'CAIXA 20X220G','CX ',20,0,0,'KG','KG','20X220G'),(1157,true,current_date,0,'BALDE 11KG','BD ',1,11,11,'KG','KG','BD 11KG'),(1158,true,current_date,0,'CAIXA 6X3700KG','CX ',6,3700,3700,'KG','KG','6X3700'),(1159,true,current_date,0,'CAIXA 18X270G','CX ',18,270,270,'GR','GR','18X270G'),(1160,true,current_date,0,'CAIXA 17X360G','CX ',17,360,360,'GR','GR','17X360G'),(1161,true,current_date,0,'BALDE 3600KG','BD ',1,3600,3600,'KG','KG','BD 3600KG'),(1162,true,current_date,0,'SACO 25KG','SC ',1,25,25,'KG','KG','SC 25KG'),(1163,true,current_date,0,'CAIXA C/15','CX ',15,0,0,'KG','KG','C/15'),(1164,true,current_date,0,'CAIXETA 14X30G','CXT',14,0,0,'KG','KG','CXT 14X30G'),(1165,true,current_date,0,'CAIXA C/3 DZ','CX ',36,0,0,'KG','KG','CX C/3 DZ'),(1166,true,current_date,0,'CAIXA C/4 DZ','CX ',48,0,0,'KG','KG','CX C/4 DZ'),(1167,true,current_date,0,'CAIXA 56X140G','CX ',56,0,0,'KG','KG','CX 56X140G'),(1168,true,current_date,0,'CAIXA 42X140G','CX ',42,0,0,'KG','KG','CX 42X140G'),(1169,true,current_date,0,'CAIXETA 20X40G','CXT',20,0,0,'KG','KG','CXT 20X40G'),(1170,true,current_date,0,'BALDE C/ 5KG','BD ',1,0,0,'KG','KG','BD C/ 5KG'),(1171,true,current_date,0,'CAIXA 06X5KG','CX ',6,0,0,'KG','KG','CX 06X5KG'),(1172,true,current_date,0,'CAIXA 60X500G','CX ',60,0,0,'KG','KG','CX 60X500G'),(1173,true,current_date,0,'CAIXA 12X89GR','CX ',12,1020,1020,'GR','GR','12X85GR'),(1174,true,current_date,0,'MILHEIRO','MIL',1,1,1,'KG','KG','MIL'),(1175,true,current_date,0,'CAIXETA 15X36G','CXT',15,540,540,'GR','GR','15X36G'),(1176,true,current_date,0,'DISPLAY 50X3GR','DP ',50,150,150,'GR','GR','50X3GR'),(1177,true,current_date,0,'DISPLAY 20X22R','DP ',20,440,440,'GR','GR','20X22'),(1178,true,current_date,0,'DISPLAY 20X20G','DP ',20,400,400,'GR','GR','20X20G'),(1179,true,current_date,0,'DISPLAY 20X15G','DP ',20,300,300,'GR','GR','20X15G'),(1180,true,current_date,0,'UNIDADE 1X22G','UN ',1,0,0,'KG','KG','1X22G'),(1181,true,current_date,0,'CAIXETA 150X7G','CXT',1,1050,1050,'GR','GR','150X7'),(1182,true,current_date,0,'CAIXA 6X2,5KG','CX ',6,15,15,'KG','KG','6X2,5KG'),(1183,true,current_date,0,'CAIXA 6X900G','CX ',6,5400,5400,'GR','GR','6X900G'),(1184,true,current_date,0,'CAIXETA 150X6G','CXT',1,900,900,'GR','GR','150X6'),(1185,true,current_date,0,'UNIDADE 1X2,5KG','UN ',1,2500,2500,'GR','GR','1X2,5KG'),(1186,true,current_date,0,'GALAO 3,3KG','GL ',1,0,0,'KG','KG','GALAO 3,3KG'),(1187,true,current_date,0,'CAIXA 15X750G','CX ',15,0,0,'KG','KG','15X750G'),(1188,true,current_date,0,'UNIDADE 1X750G','UN ',1,0,0,'KG','KG','1X750G'),(1189,true,current_date,0,'CAIXA 12X237ML','CX ',12,0,0,'KG','KG','CX 12X237ML'),(1190,true,current_date,0,'UNIDADE 1X237ML','UN ',1,0,0,'KG','KG','UN 1X237ML'),(1191,true,current_date,0,'CAIXA 28X80G','CX ',28,0,0,'KG','KG','CX 28X80G '),(1192,true,current_date,0,'CAIXA C/12KG','CX ',12,0,0,'KG','KG','CAIXA 12KG'),(1193,true,current_date,0,'CAIXA 16KG ','CX ',12,0,0,'KG','KG','CX 12KG'),(1194,true,current_date,0,'CAIXA 16KG ','CX ',16,0,0,'KG','KG','CX 16KG'),(1195,true,current_date,0,'CAIXA 20KG','CX ',20,0,0,'KG','KG','CX 20KG '),(1196,true,current_date,0,'CAIXA 7,20KG','CX ',1,0,0,'KG','KG','7,20KG'),(1197,true,current_date,0,'CAIXA 7,200KG  ','CX ',60,0,0,'KG','KG','CX 7,200KG '),(1198,true,current_date,0,'CAIXA 12X460G','CX ',12,0,0,'KG','KG','CX 12X460G'),(1199,true,current_date,0,'CAIXA 6X650G','CX ',6,0,0,'KG','KG','CX 6X650G'),(1200,true,current_date,0,'CAIXA 16X300G','CX ',16,0,0,'KG','KG','CX 16X300G'),(1201,true,current_date,0,'CAIXA12X12X56G','CX ',12,0,0,'KG','KG','CX 12X12X56'),(1202,true,current_date,0,'CAIXA 36X56G','CX ',36,0,0,'KG','KG','CX 36X56G'),(1203,true,current_date,0,'CAIXA 3X2,5KG','CX ',3,0,0,'KG','KG','CX 3X2,5KG '),(1204,true,current_date,0,'CAIXA 8X1KG','CX ',8,0,0,'KG','KG','CX 8X1KG'),(1205,true,current_date,0,'CAIXA 24X125G','CX ',24,0,0,'KG','KG','24X125G'),(1206,true,current_date,0,'CAIXA 15X880G','CX ',15,0,0,'KG','KG','CX 15X880G'),(1207,true,current_date,0,'CAIXA 2X3,65OG','CX ',2,0,0,'KG','KG','CX 2X3,650G'),(1208,true,current_date,0,'UNIDADE 1X650G','UN ',1,0,0,'KG','KG','UN 1X650G'),(1209,true,current_date,0,'UNIDADE 1X672G','UN ',1,0,0,'KG','KG','UN 1X672G'),(1210,true,current_date,0,'PACOTE 5X150G','PC ',5,0,0,'KG','KG','5X150G'),(1211,true,current_date,0,'UNIDADE 1X880G','UN ',1,0,0,'KG','KG','UN 1X880G'),(1212,true,current_date,0,'CAIXA 28X100G','CX ',28,0,0,'KG','KG','28X100G'),(1213,true,current_date,0,'CAIXA 28X185G','CX ',28,0,0,'KG','KG','28X185G'),(1214,true,current_date,0,'CAIXA 21X200G','CX ',21,0,0,'KG','KG','21X200G'),(1215,true,current_date,0,'CAIXA 28X360G','CX ',28,0,0,'KG','KG','28X360G'),(1216,true,current_date,0,'CAIXA 24X130G','CX ',24,0,0,'KG','KG','24X130G'),(1217,true,current_date,0,'PACOTE 6X120G','PC ',6,0,0,'KG','KG','6X120G'),(1218,true,current_date,0,'CAIXA 19X220G','CX ',19,0,0,'KG','KG','19X220G'),(1219,true,current_date,0,'CAIXA 6X600G','CX ',6,0,0,'KG','KG','6X600G'),(1220,true,current_date,0,'CAIXA 48X180G','CX ',48,0,0,'KG','KG','48X180G'),(1221,true,current_date,0,'CAIXA 10X900G','CX ',10,0,0,'KG','KG','10X900G'),(1222,true,current_date,0,'CAIXA 6X540G','CX ',6,0,0,'KG','KG','6X540G'),(1223,true,current_date,0,'CAIXA 10X850G','CX ',10,0,0,'KG','KG','10X850G'),(1224,true,current_date,0,'CAIXA 48X170G','CX ',48,0,0,'KG','KG','48X170G'),(1225,true,current_date,0,'PACOTE 6X75G','PC ',6,0,0,'KG','KG','6X75G'),(1226,true,current_date,0,'PACOTE 12X75G','PC ',12,0,0,'KG','KG','12X75G'),(1227,true,current_date,0,'UNIDADE 1X220G','UN ',1,0,0,'KG','KG','1X220G'),(1228,true,current_date,0,'UNIDADE 1X540G','UN ',1,0,0,'KG','KG','1X540G'),(1229,true,current_date,0,'CAIXA 16X320G','CX ',16,0,0,'KG','KG','16X320G'),(1230,true,current_date,0,'UNIDADE 1X185G','UN ',1,0,0,'KG','KG','1X185G'),(1231,true,current_date,0,'CAIXA 10X220G','CX ',10,0,0,'KG','KG','10X220G'),(1232,true,current_date,0,'PACOTE 12X100G','PC ',12,0,0,'KG','KG','12X100G'),(1233,true,current_date,0,'CAIXA 33X100G','CX ',33,0,0,'KG','KG','33X100G'),(1234,true,current_date,0,'CAIXA 6X5K','CX ',30,0,0,'KG','KG','6X5K'),(1235,true,current_date,0,'CAIXA 12X390G','CX ',12,0,0,'KG','KG','12X390G '),(1236,true,current_date,0,'PACOTE C/400','PCT',400,0,0,'KG','KG','C 400'),(1237,true,current_date,0,'FARDO C/ 50X5G','FD ',50,0,0,'KG','KG','50X5G'),(1238,true,current_date,0,'PACOTE C/ 1X5G','PCT',1,0,0,'KG','KG','1X5G '),(1239,true,current_date,0,'FARDO C/ 50X10G','FD ',50,0,0,'KG','KG','50X10G'),(1240,true,current_date,0,'PACOTE C/ 1X10G','PCT',1,0,0,'KG','KG','1X10G'),(1241,true,current_date,0,'FARDO C/ 50X80G','FD ',50,0,0,'KG','KG','50X80G'),(1242,true,current_date,0,'PACOTE C/ 1X80G','PCT',1,0,0,'KG','KG','1X80G'),(1243,true,current_date,0,'FARDO C/ 50X30G','FD ',50,0,0,'KG','KG','50X30G'),(1244,true,current_date,0,'PACOTE C/ 1X30G','PCT',1,0,0,'KG','KG','1X30G 1'),(1245,true,current_date,0,'FARDO C/ 100X5G','FD ',100,0,0,'KG','KG','100X5G'),(1246,true,current_date,0,'FARDO C/ 100X80G','FD ',100,0,0,'KG','KG','100X80G'),(1247,true,current_date,0,'PACOTE C/ 3G','PCT',1,0,0,'KG','KG','3G'),(1248,true,current_date,0,'LATA 10K','LT ',10,0,0,'KG','KG','10K'),(1249,true,current_date,0,'CAIXA 20X480G','CX ',20,0,0,'KG','KG','20X480G '),(1250,true,current_date,0,'UNIDADE 1X480G','UN ',1,0,0,'KG','KG','1X480G'),(1251,true,current_date,0,'PACOTE C/12','PC ',1,0,0,'KG','KG','C/12'),(1252,true,current_date,0,'PACOTE 10X50G','PC ',10,0,0,'KG','KG','10X50G'),(1253,true,current_date,0,'CAIXA 36X50G','CX ',36,0,0,'KG','KG','36X50G'),(1254,true,current_date,0,'CAIXA 36X50G','CX ',36,0,0,'KG','KG','36X50G'),(1255,true,current_date,0,'CAIXA 30X24G','CX ',30,0,0,'KG','KG','30X24G '),(1256,true,current_date,0,'UNIDADE 1X50G','UN ',1,0,0,'KG','KG','1X50G'),(1257,true,current_date,0,'PACOTE C/5KG ','PCT',5,0,0,'KG','KG','5KG'),(1258,true,current_date,0,'CAIXA C/20KG','CX ',20,0,0,'KG','KG','20KG'),(1259,true,current_date,0,'CAIXA 30X70G','CX ',30,0,0,'KG','KG','30X70G'),(1260,true,current_date,0,'UNIDADE 1X70G','UN ',1,0,0,'KG','KG','1X70G'),(1261,true,current_date,0,'UNIDADE 12X234ML','UN ',12,0,0,'KG','KG','12X234ML'),(1262,true,current_date,0,'CAIXA 12X234ML','CX ',12,0,0,'KG','KG','12X234ML'),(1263,true,current_date,0,'UNIDADE 1X234ML','UN ',1,0,0,'KG','KG','1X234ML'),(1264,true,current_date,0,'UNIDADE 24X8','UN ',8,0,0,'GR','KG','24'),(1265,true,current_date,0,'CAIXA 8X1LT','CX ',8,8,8,'KG','KG','8X1LT'),(1266,true,current_date,0,'CAIXA 72X80G','CX ',72,0,0,'KG','KG','72X80G'),(1267,true,current_date,0,'CAIXA 06X06','CX ',6,0,0,'GR','GR','06X06'),(1268,true,current_date,0,'CAIXA 10X540G','CX ',540,0,0,'KG','KG','10X540'),(1269,true,current_date,0,'UNIDADE 1X200ML','UN ',1,0,0,'KG','KG','1X200ML'),(1270,true,current_date,0,'CAIXA 30X100ML','CX ',30,0,0,'KG','KG','30X100ML'),(1271,true,current_date,0,'CAIXA 20X30UND','CX ',20,0,0,'KG','KG','20X30UN'),(1272,true,current_date,0,'UNIDADE 1X30UND','UND',1,0,0,'KG','KG','1X30UND'),(1273,true,current_date,0,'CAIXA 2X10KG','CX ',2,0,0,'KG','KG','2X10G'),(1274,true,current_date,0,'CAIXA 20X270g','CX ',1,0,0,'KG','KG','20X270G'),(1275,true,current_date,0,'CAIXA 20X270g','CX ',20,0,0,'KG','KG','20X270G'),(1276,true,current_date,0,'POTE 2 KG','PT ',1,0,0,'KG','KG','2 KG'),(1277,true,current_date,0,'PACOTE 06X200ml','PC ',6,0,0,'KG','KG','06X200ML'),(1278,true,current_date,0,'CAIXETA 24X20G','CXT',24,0,0,'KG','KG','24X20G'),(1279,true,current_date,0,'CAIXETA 24X25g','CXT',24,0,0,'KG','KG','24X25G'),(1281,true,current_date,0,'CAIXA 36X156g','CX ',36,0,0,'KG','KG','36X156G'),(1282,true,current_date,0,'PACOTE 5KG','PC ',1,0,0,'KG','KG','1X5KG'),(1284,true,current_date,0,'CAIXA 30X250G','CX ',30,0,0,'KG','KG','30X250G'),(1285,true,current_date,0,'UNIDADE 1X25G','UN ',1,0,0,'KG','KG','1X25G'),(1286,true,current_date,0,'CAIXA 15X250G','CX ',15,0,0,'KG','KG','15X250G'),(1287,true,current_date,0,'FARDO 15X250G','FD ',15,0,0,'KG','KG','15X250G'),(1288,true,current_date,0,'CAIXA 36X120G','CX ',36,0,0,'KG','KG','36X120G'),(1289,true,current_date,0,'CAIXA 20X240G','CX ',20,0,0,'KG','KG','20X240G'),(1290,true,current_date,0,'CAIXA 20X25X100G','CX ',500,0,0,'KG','KG','20X25X100G'),(1291,true,current_date,0,'CAIXA 1X45','CX ',45,0,0,'KG','KG','1X45'),(1292,true,current_date,0,'CAIXA 45X1','CX ',1,0,0,'KG','KG','45X1'),(1293,true,current_date,0,'CAIXETA 15X35G','CXT',15,0,0,'KG','KG','15X35G'),(1294,true,current_date,0,'CAIXA 25X250G','CX ',25,0,0,'KG','KG','25X250G'),(1295,true,current_date,0,'LATA 1,8KG','LT ',1,0,0,'KG','KG','1X1,8'),(1296,true,current_date,0,'CAIXA 24X118ML','CX ',24,2832,0,'KG','KG','24X118ML'),(1297,true,current_date,0,'PACOTE 6X300ML','PC ',6,0,0,'KG','KG','6X300ML'),(1298,true,current_date,0,'PACOTE 6X280ML','PC ',6,0,0,'KG','KG','6X280ML'),(1299,true,current_date,0,'UNIDADE 1X280ML','UN ',1,0,0,'KG','KG','1X280ML'),(1300,true,current_date,0,'UNIDADE 1X156G','UND',1,156,156,'KG','KG','1X156G'),(1301,true,current_date,0,'CAIXA 4X6X300ML','CX ',24,0,0,'KG','KG','4X6X300ML'),(1302,true,current_date,0,'CAIXA 4X6X280ML','CX ',24,0,0,'KG','KG','4X6X280ML'),(1303,true,current_date,0,'PACOTE 1X500GR','PC ',1,0,0,'KG','KG','1X500GR'),(1304,true,current_date,0,'PACOTE 1X300GR','PC ',1,0,0,'KG','KG','1X300GR'),(1305,true,current_date,0,'UNIDADE 1X57G','UN ',1,0,0,'KG','KG','1X57G'),(1306,true,current_date,0,'CAIXA 8X500ML','CX ',8,0,0,'KG','KG','8X500ML'),(1307,true,current_date,0,'PACOTE 3KG','PC ',1,0,0,'KG','KG','1X3KG'),(1308,true,current_date,0,'CAIXA 25X140G','CX ',25,0,0,'KG','KG','25X140G'),(1309,true,current_date,0,'CAIXA 20X06','CX ',20,0,0,'KG','KG','20X06'),(1310,true,current_date,0,'CAIXA 8X200GR','CX ',8,1600,1600,'GR','GR','8X200GR'),(1311,true,current_date,0,'FARDO 24X60GR','FRD',24,1440,1440,'GR','GR','24X60GR'),(1312,true,current_date,0,'FARDO 12X400GR','FRD',12,4800,4800,'GR','GR','12X400GR'),(1313,true,current_date,0,'FARDO 12X250GR','FRD',12,3000,3000,'GR','GR','12X250GR'),(1314,true,current_date,0,'FARDO 8X900G','FD ',8,0,0,'KG','KG','8X900G'),(1315,true,current_date,0,'FARDO 2KG','FD ',1,0,0,'KG','KG','2KG'),(1316,true,current_date,0,'CAIXA 24X30UND','CX ',24,0,0,'KG','KG','24X30UND'),(1317,true,current_date,0,'PACOTE 6X30UND','PC ',6,0,0,'KG','KG','6X30UND'),(1318,true,current_date,0,'PACOTE 12X1','PC ',12,0,0,'KG','KG','12X1'),(1319,true,current_date,0,'PACOTE 60X1','PC ',60,0,0,'KG','KG','60X1'),(1320,true,current_date,0,'PACOTE 36X1','PC ',36,0,0,'KG','KG','36X1'),(1321,true,current_date,0,'CAIXA 6X1800GR','CX ',6,10800,10800,'GR','GR','6X1800GR'),(1322,true,current_date,0,'UNIDADE 1X1800GR','UND',1,1800,1800,'GR','GR','1X1800GR'),(1280,true,current_date,0,'CAIXETA C/7KG','CXT',1,0,0,'KG','KG','7KG'),(1323,true,current_date,0,'PACOTE 1X50UND','PCT',1,300,300,'GR','GR','1X50UND'),(1324,true,current_date,0,'CAIXA 27X220GR','CX ',27,5940,5940,'GR','GR','27X220GR'),(1325,true,current_date,0,'CAIXA 32X160G','CX ',32,0,0,'KG','KG','32X160G'),(1326,true,current_date,0,'PACOTE 6X115GR','PCT',6,690,690,'GR','GR','6X115GR'),(1327,true,current_date,0,'CAIXA 8X300G','CX ',8,2400,2400,'GR','GR','8X300'),(1328,true,current_date,0,'DISPLAY 15X20GR','DP ',15,300,300,'GR','GR','15X20GR'),(1329,true,current_date,0,'PACOTE C/2,5KG','PC ',1,2500,2500,'GR','GR','1X2,5G'),(508,true,current_date,0,'UNIDADE 1X20','UND',1,20,20,'GR','GR','1X20GR'),(1330,true,current_date,0,'DISPLAY 15X35GR','DP ',15,525,525,'GR','GR','15X35GR'),(1331,true,current_date,0,'DISPLAY 12X200GR','DP ',12,2400,2400,'GR','GR','12X200GR'),(1332,true,current_date,0,'CAIXA 20X200','CX ',20,0,0,'KG','KG','20X200'),(1333,true,current_date,0,'UNIDADE 1X200','UND',1,0,0,'KG','KG','1X200'),(1334,true,current_date,0,'CAIXA 48X15UND','CX ',48,1200,1200,'GR','GR','48X15UND'),(1335,true,current_date,0,'CAIXA 1X72UND','CX ',1,400,400,'GR','GR','1X72UND'),(1336,true,current_date,0,'CAIXA 24X100MT','CX ',24,300,300,'GR','GR','24X100MT'),(1337,true,current_date,0,'CAIXA 48X50M','CX ',48,200,200,'GR','GR','48X50M'),(1338,true,current_date,0,'CAIXA 5X28UND','CX ',5,1200,1200,'GR','GR','5X28UND'),(1339,true,current_date,0,'CAIXA 5X20UND','CX ',5,1200,1200,'GR','GR','5X20UND'),(1340,true,current_date,0,'CAIXA 5X24UND','CX ',5,1200,1200,'GR','GR','5X24UND'),(1341,true,current_date,0,'CAIXA 96X90GR','CX ',96,8640,8640,'GR','GR','96X90GR'),(1342,true,current_date,0,'KIT 1X1','KIT',1,540,540,'GR','GR','1X1'),(1343,true,current_date,0,'CAIXA 10X57GR','CX ',10,570,570,'GR','GR','10X57GR'),(1344,true,current_date,0,'UNIDADE 1X114GR','UND',1,114,114,'GR','GR','1X114GR'),(1345,true,current_date,0,'CAIXA 80X114GR','CX ',80,9120,9120,'GR','GR','80X114GR'),(1346,true,current_date,0,'CAIXA 6X3,1KG','CX ',6,18600,18600,'GR','GR','6X3,1KG'),(1347,true,current_date,0,'UNIDADE 1X3,100G','UND',1,3100,3100,'GR','GR','1X3,100G'),(1348,true,current_date,0,'PACOTE 1X5UND','PC ',1,0,0,'KG','KG','1X5UND'),(1349,true,current_date,0,'CAIXA 48X290GR','CX ',48,13920,13920,'GR','GR','48X290GR'),(1350,true,current_date,0,'CAIXA 30X228,6GR','CX ',30,6858,6858,'GR','GR','30X228,6GR'),(1351,true,current_date,0,'UNIDADE 1X228,6GR','UND',1,2286,2286,'GR','GR','1X228,6GR'),(1352,true,current_date,0,'CAIXA 6X800GR','CX ',6,4800,4800,'GR','GR','6X800GR'),(1353,true,current_date,0,'UNIDADE 1X126GR','UND',1,126,126,'GR','GR','1X126GR'),(1354,true,current_date,0,'CAIXA 36X126GR','CX ',36,4536,4536,'GR','GR','36X126GR'),(1355,true,current_date,0,'CAIXA 1X25KG','CX ',1,25000,25000,'GR','GR','1X25KG'),(1356,true,current_date,0,'PACOTE 1X4UND','PCT',1,200,200,'GR','GR','1X4UND'),(1357,true,current_date,0,'CAIXA 24X355ML','CX ',24,9600,9600,'GR','GR','24X355ML'),(1358,true,current_date,0,'UNIDADE 1X355ML','YND',1,400,400,'GR','GR','1X335ML'),(1359,true,current_date,0,'CAIXA 12X1,100KG','CX ',12,13200,13200,'GR','GR','12X1,100KG'),(1360,true,current_date,0,'CAIXA 12X1,06KG','CX ',12,12720,12720,'GR','GR','12X1,06KG'),(1361,true,current_date,0,'CAIXA 12X1,15KG','CX ',12,13800,13800,'GR','GR','12X1,15KG'),(1362,true,current_date,0,'CAIXA 12X1,05KG','CX ',12,12600,12600,'GR','GR','12X1,05KG'),(1363,true,current_date,0,'UNIDADE 1X1,05KG','UND',1,1050,1050,'GR','GR','1X1,05KG'),(1364,true,current_date,0,'UNIDADE 1X1,15KG','UND',1,1150,1150,'GR','GR','1X1,15KG'),(1365,true,current_date,0,'UNIDADE 1X1,06KG','UND',1,1060,1060,'GR','GR','1X1,06KG'),(1366,true,current_date,0,'UNIDADE 1X1,100KG','UND',1,1100,1100,'GR','GR','1X1,100KG'),(1367,true,current_date,0,'CAIXA 16X1KG','CX ',16,0,0,'KG','KG','16X1KG'),(1368,true,current_date,0,'UNIDADE 1X88GR','UND',1,88,88,'GR','GR','1X88GR'),(1369,true,current_date,0,'FARDO 10X2KG','FRD',10,20000,20000,'GR','GR','10X2KG'),(1370,true,current_date,0,'PACOTE 12X70UND','PCT',12,1800,1800,'GR','GR','12X70UND'),(1371,true,current_date,0,'CAIXA 24X70UND','CX ',24,1500,1500,'GR','GR','24X70UND'),(1372,true,current_date,0,'CAIXA 6X3,2KG','CX ',6,0,0,'KG','KG','6X3,2KG'),(1373,true,current_date,0,'UNIDADE 1X3,2KG','UND',1,0,0,'KG','KG','1X3,2KG'),(1374,true,current_date,0,'CAIXA 12X380G','CX ',380,0,0,'KG','KG','12X380G'),(1375,true,current_date,0,'UNIDADE 1X380GR','UND',1,0,0,'KG','KG','1X380G'),(1376,true,current_date,0,'CAIXA 6X2.240KG','CX ',6,0,0,'KG','KG','6X2.240KG'),(1377,true,current_date,0,'UNIDADE 1X2.240KG','UND',1,0,0,'KG','KG','1X2.240KG'),(1378,true,current_date,0,'CAIXA 6X2.120G','CX ',6,0,0,'KG','KG','6X2.120G'),(1379,true,current_date,0,'UNIDADE 1X2.120G','UND',1,0,0,'KG','KG','1X2.120G'),(1380,true,current_date,0,'BALDE 1X9.8KG','BD ',1,0,0,'KG','KG','1X9.8KG'),(1381,true,current_date,0,'CAIXA 12X380G','CX ',12,0,0,'KG','KG','12X380G'),(1382,true,current_date,0,'CAIXA 10X672G','CX ',10,0,0,'KG','KG','10X672G'),(1383,true,current_date,0,'UNIDADE 1X672G','UND',1,0,0,'KG','KG','1X672G'),(1384,true,current_date,0,'CAIXA 15X672G','CX ',15,0,0,'KG','KG','15X672G'),(1385,true,current_date,0,'CAIXA 4X5L','CX ',4,0,0,'KG','KG','4X5L'),(1386,true,current_date,0,'UNIDADE 1X5L','UND',1,0,0,'KG','KG','1X5L'),(1387,true,current_date,0,'UNIDADE 1X14KG','UND',1,0,0,'KG','KG','1X14KG'),(1388,true,current_date,0,'PACOTE 1X250GR','PCT',1,250,250,'GR','GR','1X250GR'),(1389,true,current_date,0,'POTE 1X220GR','PT ',1,220,220,'GR','GR','1X220GR'),(1390,true,current_date,0,'POTE 1X230GR','PT ',1,230,230,'GR','GR','1X230GR'),(1391,true,current_date,0,'SACO 1X40KG','SC ',1,40000,40000,'GR','GR','1X40KG'),(1392,true,current_date,0,'CAIXA 24X40G','CX ',24,0,0,'KG','KG','24X40G'),(1393,true,current_date,0,'CAIXA 40X35GR','CX ',40,1400,1400,'GR','GR','40X35GR'),(1394,true,current_date,0,'BANDEIJA 1X600GR','BD ',1,600,600,'GR','GR','1X600GR'),(1395,true,current_date,0,'BANDEIJA 1X540GR','BD ',1,540,540,'GR','GR','1X540GR'),(1396,true,current_date,0,'PACOTE 6X80GR','PCT',6,480,480,'GR','GR','6X80GR'),(1397,true,current_date,0,'BANDEIJA 1X400GR','BD ',1,400,400,'GR','GR','1X400GR'),(1398,true,current_date,0,'CARTELA 1X2UND','CRT',1,50,50,'GR','GR','1X2UND'),(1399,true,current_date,0,'CARTELA 1X6UND','CRT',1,120,120,'GR','GR','1X6UND'),(1400,true,current_date,0,'UNIDADE 1X1','UND',1,100,100,'GR','GR','1X1'),(1401,true,current_date,0,'CARTELA 1X4UND','CRT',1,150,150,'GR','GR','1X4UND'),(1402,true,current_date,0,'UNIDADE 1X125ML','UND',1,135,135,'GR','GR','1X125ML'),(1403,true,current_date,0,'UNIDADE 1X49GR','UND',1,49,49,'GR','GR','1X49GR'),(1404,true,current_date,0,'UNIDADE 1X193GR','UND',1,193,193,'GR','GR','1X193GR'),(1405,true,current_date,0,'CARTELA 1X1UND','CRT',1,100,100,'GR','GR','1X1UND'),(1406,true,current_date,0,'CAIXA 185X7GR','CX ',185,1295,1295,'GR','GR','185X7GR'),(1407,true,current_date,0,'CAIXA 4X3KG','CX ',4,12000,12000,'GR','GR','4X3KG'),(1408,true,current_date,0,'CAIXA 4X3,100KG','CX ',4,12400,12400,'GR','GR','4X3,100KG'),(1409,true,current_date,0,'PACOTE 1X5UND','PC ',1,0,0,'KG','KG','1X5UND'),(1410,true,current_date,0,'CAIXA 21X300GR','CX ',21,6300,6300,'GR','GR','21X300GR'),(1411,true,current_date,0,'CAIXA 40X350GR','CX ',40,1400,1400,'GR','GR','40X350GR'),(1412,true,current_date,0,'PACOTE 1X2UND','PCT',1,10,10,'GR','GR','1X2UND'),(1413,true,current_date,0,'FARDO 30X30GR','FRD',30,900,900,'GR','GR','30X30GR'),(1414,true,current_date,0,'FARDO 50X2UND','FRD',50,300,300,'GR','GR','50X2UND'),(1415,true,current_date,0,'FARDO 40X45UND','FRD',40,300,300,'GR','GR','40X45UND'),(1416,true,current_date,0,'FARDO 24X50UND','FRD',24,300,300,'GR','GR','24X50UND'),(1417,true,current_date,0,'FARDO 48X50UND','FRD',48,300,300,'GR','GR','48X50UND'),(1418,true,current_date,0,'FARDO 40X50UND','FRD',40,300,300,'GR','GR','40X50UND'),(1419,true,current_date,0,'FARDO 8X10X160UND','FAR',80,300,300,'GR','GR','8X10X160UND'),(1420,true,current_date,0,'PACOTE 1X45UND','PCT',1,20,20,'GR','GR','1X45UND'),(1421,true,current_date,0,'PACOTE 1X160UND','PCT',1,20,20,'GR','GR','1X160UND'),(1422,true,current_date,0,'PACOTE 1X1KG','PCT',1,1000,1000,'GR','GR','1X1KG'),(1423,true,current_date,0,'FARDO 10X250GR','FRD',10,2500,2500,'GR','GR','10X250GR'),(1424,true,current_date,0,'DISPLAY 1X564GR','DP ',1,564,564,'GR','GR','1X564GR'),(1425,true,current_date,0,'PACOTE 1X75G','PC ',1,75,75,'GR','GR','1X75G'),(1426,true,current_date,0,'DISPLAY 1X608GR','DP ',1,608,608,'GR','GR','1X608GR'),(1427,true,current_date,0,'CAIXA 24X335G','CX ',24,8040,8040,'GR','GR','24X335G'),(1428,true,current_date,0,'UNIDADE 1X335G','UND',1,335,335,'GR','GR','1X335G'),(1429,true,current_date,0,'CAIXA 1X2,016KG','CX ',1,2016,2016,'GR','GR','1X2,016KG'),(1430,true,current_date,0,'CAIXA 24X64GR','CX ',24,1536,1536,'GR','GR','24X64GR'),(1431,true,current_date,0,'CAIXA 24X68GR','CX ',24,1632,1632,'GR','GR','24X68GR'),(1432,true,current_date,0,'CAIXA 50X109GR','CX ',50,5450,5450,'GR','GR','50X109GR'),(1433,true,current_date,0,'CAIXA 50X87GR','CX ',50,4350,4350,'GR','GR','50X87GR'),(1434,true,current_date,0,'UNIDADE 1X66GR','UND',1,66,66,'GR','GR','1X66GR'),(1435,true,current_date,0,'UNIDADE 1X48GR','UND',1,48,48,'GR','GR','1X48GR'),(1436,true,current_date,0,'UNIDADE 1X51GR','UND',1,51,51,'GR','GR','1X51GR'),(1437,true,current_date,0,'UNIDADE 1X87GR','UND',1,87,87,'GR','GR','1X87GR'),(1438,true,current_date,0,'UNIDADE 1X109GR','UND',1,109,109,'GR','GR','1X109GR'),(1439,true,current_date,0,'UNIDADE 1X68GR','UND',1,68,68,'GR','GR','1X68GR'),(1440,true,current_date,0,'CAIXA 30X15GGR','CX ',30,450,450,'GR','GR','30X15GR'),(1441,true,current_date,0,'FARDO 6X2KG','FD ',6,0,0,'KG','KG','6X2KG'),(1442,true,current_date,0,'CAIXA 12X125G','CX ',12,0,0,'KG','KG','12X125G'),(1443,true,current_date,0,'FARDO 16X500G','FD ',16,8000,8000,'GR','GR','16X500G'),(1444,true,current_date,0,'CUIA 1X1','CU ',1,0,0,'KG','KG','1X1'),(1445,true,current_date,0,'PACOTE 12X300ML','PC ',12,0,0,'KG','KG','12X300ML'),(1446,true,current_date,0,'KIT 3X90GR','KIT',3,270,270,'GR','GR','3X90GR'),(1447,true,current_date,0,'CAIXA 24X280GR','CX ',24,6720,6720,'GR','GR','24X280GR'),(1448,true,current_date,0,'UNIDADE 1X280GR','UND',1,280,280,'GR','GR','1X280G'),(1449,true,current_date,0,'PACOTE 5KG','PC ',1,5,5,'KG','KG','1X5KG'),(1450,true,current_date,0,'UNIDADE 1X170ML','UND',1,0,0,'KG','KG','1X170ML'),(1451,true,current_date,0,'PACOTE 15X90G','PC ',15,1350,1350,'GR','GR','15X90G'),(1452,true,current_date,0,'CAIXA 1X30KG','CX ',1,30,30,'KG','KG','1X30KG'),(1453,true,current_date,0,'FARDO 60X3','FD ',60,0,0,'KG','KG','60X3'),(1454,true,current_date,0,'UNIDADE 1X275GR','UND',1,275,275,'GR','GR','1X275GR'),(1455,true,current_date,0,'DISPLAY 10X57GR','DP ',10,570,570,'GR','GR','10X57GR'),(1456,true,current_date,0,'CAIXA 18X50GR','CX ',18,900,900,'GR','GR','18X50GR'),(1457,true,current_date,0,'CAIXA 18X170GR','CX ',18,3060,3060,'GR','GR','18X170GR'),(1458,true,current_date,0,'CAIXA 18X70GR','CX ',18,1260,1260,'GR','GR','18X70GR'),(1459,true,current_date,0,'CAIXA 12X1,020KG','CX ',12,12240,12240,'GR','GR','12X1,020KG'),(1460,true,current_date,0,'UNIDADE 1X1,020KG','UND',1,1020,1020,'GR','GR','1X1,020KG'),(1461,true,current_date,0,'CAIXA 6X2,180KG','CX ',6,13080,13080,'GR','GR','6X2,180GR'),(1462,true,current_date,0,'MEIA DUZIA 6X1','MD ',6,300,300,'GR','GR','6X1'),(1463,true,current_date,0,'CAIXETA C/7KG','CX ',7,7,7,'KG','KG','7KG'),(1464,true,current_date,0,'UNIDADE 1X2,180KG','UND',1,0,0,'KG','KG','1X2,180'),(1465,true,current_date,0,'CAIXA 20X390GR','CX ',20,0,0,'KG','KG','20X390GR'),(1466,true,current_date,0,'CAIXA 108X90GR','CX ',108,9720,9720,'GR','GR','108X90GR'),(1467,true,current_date,0,'DUZIA 12X75UND','DZ ',12,250,250,'GR','GR','12X75UND'),(1468,true,current_date,0,'UNIDADE 1X75UND','UND',1,50,50,'GR','GR','1X75UND'),(1469,true,current_date,0,'PACOTE 6X510ML','PCT',6,3180,3180,'GR','GR','6X510ML'),(1470,true,current_date,0,'UNIDADE 1X510ML','UND',1,530,530,'GR','GR','1X510ML'),(1471,true,current_date,0,'FARDO 50X40G','FD ',50,0,0,'KG','KG','50X40G'),(1472,true,current_date,0,'CAIXA 10X50UND','CX ',10,0,0,'KG','KG','10X50UND'),(1473,true,current_date,0,'CAIXA 20X5','CX ',20,0,0,'KG','KG','20X5'),(1474,true,current_date,0,'CAIXA 24X5UND','CX ',24,0,0,'KG','KG','24X5UND'),(1475,true,current_date,0,'UNIDADE 1X50UND','UND',1,1500,1500,'GR','GR','1X50UND'),(1476,true,current_date,0,'UNIDADE 1X5UND','UND',1,0,0,'KG','KG','1X5UND'),(1477,true,current_date,0,'CAIXA C/7KG','CX ',7,7,7,'KG','KG','C/7KG'),(1478,true,current_date,0,'CAIXA 42X130G','CX ',42,5460,5460,'GR','GR','42X130G'),(1540,true,current_date,0,'SACO 1X50KG','SC ',1,50,50,'KG','KG','1X50KG'),(1479,true,current_date,0,'CAIXA 12X1,080KG','CX ',12,12960,12960,'GR','GR','12X1,080'),(1480,true,current_date,0,'UNIDADE 1X1,080KG','UND',1,1080,1080,'GR','GR','1X1,080'),(1481,true,current_date,0,'CAIXA 40X40GR','CX ',40,1600,1600,'GR','GR','40X40GR'),(1482,true,current_date,0,'PACOTE 1X24UND','PCT',1,150,150,'GR','GR','1X24UND'),(1483,true,current_date,0,'DISPLAY 12X68GR','DP ',12,816,816,'GR','GR','12X68GR'),(1484,true,current_date,0,'CAIXA 162X63GR','CX ',162,10206,10206,'GR','GR','162X63GR'),(1485,true,current_date,0,'CAIXA 6X170GR','CX ',6,1020,1020,'GR','GR','6X170GR'),(1486,true,current_date,0,'DISPLAY 16X30GR','DP ',16,480,480,'GR','GR','16X30GR'),(1487,true,current_date,0,'CAIXA 120X30GR','CX ',120,3600,3600,'GR','GR','120X30GR'),(1488,true,current_date,0,'CAIXA 12X550GR','CX ',12,6600,6600,'GR','GR','12X550GR'),(1489,true,current_date,0,'POTE 1X550GR','PT ',1,550,550,'GR','GR','1X550GR'),(1490,true,current_date,0,'PACOTE 1X2KG','PCT',1,2,2,'KG','KG','1X2KG'),(1491,true,current_date,0,'CAIXA 25X100UND','CX ',25,1,1,'KG','KG','25X100UND'),(1492,true,current_date,0,'CAIXA 24X180ML','CX ',24,4400,4400,'GR','GR','24X180ML'),(1493,true,current_date,0,'CAIXA 48X90GR','CX ',48,4320,4320,'GR','GR','48X90GR'),(1494,true,current_date,0,'UNIDADE 1X180ML','UND',1,195,195,'GR','GR','1X180ML'),(1495,true,current_date,0,'CAIXA 72X90GR','CX ',72,6480,6480,'GR','GR','72X90GR'),(1496,true,current_date,0,'PLACA 1X320GR','PLC',1,320,320,'GR','GR','1X320GR'),(1497,true,current_date,0,'DISPLAY 10X63GR','DP ',10,630,630,'GR','GR','10X63GR'),(1498,true,current_date,0,'CAIXA 42X180GR','CX ',42,7560,7560,'GR','GR','42X180GR'),(1499,true,current_date,0,'DISPLAY 20X40GR','DP ',20,800,800,'GR','GR','20X40GR'),(1500,true,current_date,0,'CAIXA 6X2,1KG','CX ',6,12600,12600,'GR','GR','6X2,1KG'),(1501,true,current_date,0,'UNIDADE 1X2,1KG','UND',1,2100,2100,'GR','GR','1X2,1KG'),(1502,true,current_date,0,'CAIXA 36X270GR','CX ',36,9720,9720,'GR','GR','36X270GR'),(1031,true,current_date,0,'PACOTE 3K','PCT',3,3,3,'KG','KG','C/3'),(1503,true,current_date,0,'CAIXA 36X66GR','CX ',36,2376,2376,'GR','GR','36X66GR'),(1504,true,current_date,0,'CAIXA 54X125GR','CX ',54,6750,6750,'GR','GR','54X125GR'),(1505,true,current_date,0,'CAIXA 15X200ML','CX ',15,3000,3000,'GR','GR','15X200ML'),(1506,true,current_date,0,'DUZIA 12X30GR','DZ ',12,360,360,'GR','GR','12X30GR'),(1507,true,current_date,0,'DUZIA 12X5GR','DZ ',12,60,60,'GR','GR','12X5GR'),(1508,true,current_date,0,'CAIXA 24X1','CX ',24,0,0,'GR','GR','24X1'),(1509,true,current_date,0,'LATA 2,2KG','LT ',1,2200,2200,'GR','GR','2,2KG'),(1510,true,current_date,0,'BALDE 1X1,4KG','BDE',1,1400,1400,'GR','GR','1X1,4KG'),(1511,true,current_date,0,'DISPLAY 12X78GR','DP ',12,936,936,'GR','GR','12X78GR'),(1512,true,current_date,0,'CAIXA 90X126GR','CX ',90,1340,1340,'GR','GR','90X126GR'),(1513,true,current_date,0,'DISPLAY 12X63GR','DP ',12,756,756,'GR','GR','12X63GR'),(1514,true,current_date,0,'DISPLAY 10X70GR','DP ',10,700,700,'GR','GR','10X70GR'),(1515,true,current_date,0,'CAIXA 24X213GR','CX ',24,5112,5112,'GR','GR','24X213GR'),(1516,true,current_date,0,'CAIXA 9X600GR','CX ',9,5400,5400,'GR','GR','9X600GR'),(1517,true,current_date,0,'PACOTE 6X340ML','PCT',6,2100,2100,'GR','GR','6X340ML'),(1518,true,current_date,0,'CAIXA 54X35GR','CX ',54,1890,1890,'GR','GR','54X35GR'),(1519,true,current_date,0,'UNIDADE 1X340ML','UND',1,350,350,'GR','GR','1X340ML'),(1520,true,current_date,0,'UNIDADE 1X78GR','UND',1,78,78,'GR','GR','1X78GR'),(1521,true,current_date,0,'UNIDADE 1X213GR','UND',1,213,213,'GR','GR','1X213GR'),(1522,true,current_date,0,'CAIXA 6X200','CX ',6,1200,1200,'GR','GR','6X200'),(1523,true,current_date,0,'CAIXA 32X340GR','CX ',32,10880,10880,'GR','GR','32X340GR'),(1524,true,current_date,0,'UNIDADE 1X590GR','UND',1,590,590,'GR','GR','1X590GR'),(1525,true,current_date,0,'CAIXA 30X60GR','CX ',30,1800,1800,'GR','GR','30X60GR'),(1526,true,current_date,0,'POTE 1X1,1KG','PT ',1,1100,1100,'GR','GR','1X1,1KG'),(1527,true,current_date,0,'PACOTE 10X100GR','PCT',10,1000,1000,'GR','GR','10X100GR'),(1528,true,current_date,0,'CAIXA 50X150GR','CX ',50,7500,7500,'GR','GR','50X150GR'),(1529,true,current_date,0,'CAIXA 54X165GR','CX ',54,8910,891,'GR','GR','54X165GR'),(1530,true,current_date,0,'DISPLAY 25X40GR','DSP',25,1000,1000,'GR','GR','25X40GR'),(1531,true,current_date,0,'CAIXA 44X200GR','CX ',44,8800,8800,'GR','GR','44X200GR'),(1532,true,current_date,0,'UNIDADE 1X145GR','UND',1,145,145,'GR','GR','1X145GR'),(1533,true,current_date,0,'CAIXA 24X155GR','CX ',24,3720,3720,'GR','GR','24X155GR'),(1534,true,current_date,0,'UNIDADE 1X155GR','UND',1,155,155,'GR','GR','1X155GR'),(1535,true,current_date,0,'DUZIA 12X226ML','DZ ',12,2712,2712,'GR','GR','12X226ML'),(1536,true,current_date,0,'UNIDADE 1X226ML','UND',1,226,226,'GR','GR','1X226ML'),(1537,true,current_date,0,'CAIXA 12X160GR','CX ',12,1920,1920,'GR','GR','12X160GR'),(1538,true,current_date,0,'UNIDADE 1X160GR','UND',1,160,160,'GR','GR','1X160GR'),(1539,true,current_date,0,'SACO 1X30KG','SC ',1,30,30,'KG','KG','1X30KG'),(1541,true,current_date,0,'CARTELA 1X12UND','CRT',1,150,150,'GR','GR','1X12UND'),(1542,true,current_date,0,'PACOTE 10X10ML','PC ',10,100,100,'GR','GR','10X10ML'),(1543,true,current_date,0,'UNIDADE 1X10ML','UND',1,10,10,'GR','GR','1X10ML'),(1544,true,current_date,0,'CAIXA 24X375GR','CX ',24,9000,9000,'GR','GR','24X375GR'),(1545,true,current_date,0,'CAIXA 18X190GR','CX ',18,3420,3420,'GR','GR','18X190GR'),(1546,true,current_date,0,'CAIXA 45X120GR','CX ',45,5400,5400,'GR','GR','45X120GR'),(1547,true,current_date,0,'UNIDADE 1X375GR','UND',1,375,375,'GR','GR','1X375GR'),(1548,true,current_date,0,'FARDO 14X4','FD ',14,0,0,'KG','KG','14X4'),(1549,true,current_date,0,'PACOTE 1X1,5KG','PCT',1,1500,1500,'GR','GR','1X1,5KG'),(1550,true,current_date,0,'PACOTE 1X28UND','PCT',1,500,500,'GR','GR','1X28UND'),(1551,true,current_date,0,'PACOTE 1X30UND','PCT',1,500,500,'GR','GR','1X30UND'),(1552,true,current_date,0,'PACOTE 1X20UND','PCT',1,500,500,'GR','GR','1X20UND'),(1553,true,current_date,0,'ESTOJO 1X3UND','EST',1,430,430,'GR','GR','1X3UND'),(1554,true,current_date,0,'CAIXA 40X250ML','CX ',40,0,0,'KG','KG','40X250ML'),(1555,true,current_date,0,'CAIXA 20X63GR','CX ',20,1260,1260,'GR','GR','20X63GR'),(1556,true,current_date,0,'CAIXA 2X5KG','CX ',2,10000,10000,'GR','GR','2X5KG'),(1557,true,current_date,0,'PACOTE 1X5KG','PCT',1,5000,5000,'KG','GR','1X5GR'),(1558,true,current_date,0,'CAIXA 10X540GR','CX ',10,5400,5400,'GR','GR','10X540GR'),(1559,true,current_date,0,'CAIXA 36X190GR','CX ',36,6840,6840,'GR','GR','36X190GR'),(1560,true,current_date,0,'CAIXA 32X300GR','CX ',32,9600,9600,'GR','GR','32X300GR'),(1561,true,current_date,0,'CAIXA 36X35GR','CX ',36,1260,1260,'GR','GR','36X35GR'),(1562,true,current_date,0,'CAIXA 20X1KG','CX ',20,20000,20000,'GR','GR','20X1KG'),(1563,true,current_date,0,'PACOTE 1,X2,5KG','PCT',1,2500,2500,'GR','GR','1X2,5KG'),(1564,true,current_date,0,'POTE 1X70UND','PT ',1,300,300,'GR','GR','1X70UND'),(1565,true,current_date,0,'PACOTE 1X3KG','PC ',1,3,3,'KG','KG','1X3KG'),(1566,true,current_date,0,'CAIXA 10X750GR','CX ',10,750,750,'GR','GR','10X70GR'),(1567,true,current_date,0,'UNIDADE 1X34GR','UND',1,34,34,'GR','GR','1X34GR'),(1568,true,current_date,0,'CAIXA 15X510GR','CX ',15,510,510,'GR','GR','15X510GR'),(1569,true,current_date,0,'FARDO 16X1','FD ',16,0,0,'KG','KG','16X1'),(1570,true,current_date,0,'CAIXA 60X35GR','CX ',60,2100,2100,'GR','GR','60X35GR'),(1571,true,current_date,0,'DISPLAY 30X35GR','DP ',30,1050,1050,'GR','GR','30X35GR'),(1572,true,current_date,0,'FARDO 8X8','FD ',8,64,64,'GR','GR','8X8'),(1573,true,current_date,0,'DISPALY 15X30GR','DP ',15,450,450,'GR','GR','15X30GR'),(1574,true,current_date,0,'CAIXA 60X50GR','CX ',60,3000,3000,'GR','GR','60X50GR'),(1575,true,current_date,0,'CAIXA 12X360ML','CX ',12,4320,4320,'GR','GR','12X360ML'),(1576,true,current_date,0,'UNIDADE 1X360ML','UND',1,360,360,'GR','GR','1X360ML'),(1577,true,current_date,0,'BALDE 1X1,3KG','BD ',1,1300,1300,'GR','GR','1X1,3KG'),(1578,true,current_date,0,'PACOTE 12X400GR','PCT',12,400,400,'GR','GR','12X400GR'),(1579,true,current_date,0,'FARDO 12X500ML','FD ',12,6000,6000,'GR','GR','12X500ML'),(1580,true,current_date,0,'CAIXA 24X120GR','CX ',24,2880,2880,'GR','GR','24X120GR'),(1581,true,current_date,0,'PACOTE 1X5UND','PCT',5,250,250,'GR','GR','1X5UND'),(1582,true,current_date,0,'DISPLAY 1X50UND','DP ',1,50,50,'GR','GR','1X50UND'),(1583,true,current_date,0,'DISPLAY 1X350GR','DP ',1,350,350,'GR','GR','1X350GR'),(1584,true,current_date,0,'CAIXA 34X200GR','CX ',34,6800,6800,'GR','GR','34X200GR'),(1585,true,current_date,0,'CAIXA 34X300GR','CX ',34,10200,10200,'GR','GR','34X300GR'),(1586,true,current_date,0,'UNIDADE 1X750GR','UND',1,750,750,'GR','GR','1X750GR'),(1587,true,current_date,0,'CARTELA 1X50UND','CRT',1,150,150,'GR','GR','1X50UND'),(1588,true,current_date,0,'CAIXA 32X200GR','CX ',32,6450,6450,'GR','GR','32X200GR'),(1589,true,current_date,0,'PACOTE 10X500GR','PCT',10,5000,5000,'GR','GR','10X500GR'),(1590,true,current_date,0,'PACOTE 6X200ML','PCT',6,1200,1200,'GR','GR','6X200ML'),(1591,true,current_date,0,'PACOTE 6X350ML','PCT',6,2100,2100,'GR','GR','6X350ML'),(1592,true,current_date,0,'PACOTE 12X65GR','PCT',12,780,780,'GR','GR','12X65GR'),(1593,true,current_date,0,'PACOTE 6X300GR','PCT',6,1800,1800,'GR','GR','6X300GR'),(1594,true,current_date,0,'PACOTE 6X400GR','PCT',6,2400,2400,'GR','GR','6X400GR'),(1595,true,current_date,0,'DUZIA 12X200ML','DZ ',12,2400,2400,'GR','GR','12X200ML'),(1596,true,current_date,0,'PACOTE 18X100ML','PCT',18,1800,1800,'GR','GR','18X100ML'),(1597,true,current_date,0,'PACOTE 25X200GR','PCT',25,5000,5000,'GR','GR','25X200GR'),(1598,true,current_date,0,'PACOTE 6X500ML','PCT',6,3000,3000,'GR','GR','6X500ML'),(1599,true,current_date,0,'PACOTE 15X1','PC ',15,15,15,'KG','KG','15X1'),(1600,true,current_date,0,'PACOTE 3X1UND','PCT',3,600,600,'GR','GR','3X1UND'),(1601,true,current_date,0,'PACOTE 10X200GR','PCT',10,2000,2000,'GR','GR','10X200GR'),(1602,true,current_date,0,'PACOTE 8X200GR','PCT',8,1600,1600,'GR','GR','8X200GR'),(1603,true,current_date,0,'PACOTE 18X200GR','PCT',18,3600,3600,'GR','GR','18X200GR'),(1604,true,current_date,0,'PACOTE 20X140GR','PCT',20,2800,2800,'GR','GR','20X140GR'),(1605,true,current_date,0,'PACOTE 9X120GR','PCT',9,1008,1008,'GR','GR','9X120GR'),(1606,true,current_date,0,'PACOTE 8X140GR','PCT',8,1120,1120,'GR','GR','8X140GR'),(1607,true,current_date,0,'PACOTE 6X200GR','PCT',6,1200,1200,'GR','GR','6X200GR'),(1608,true,current_date,0,'UNIDADE 1X310ML','UND',1,320,320,'GR','GR','1X310ML'),(1609,true,current_date,0,'PACOTE 10X400GR','PCT',10,4000,4000,'GR','GR','10X400GR'),(1610,true,current_date,0,'PACOTE 10X120GR','PCT',10,1200,1200,'GR','GR','10X120GR'),(1611,true,current_date,0,'PACOTE 10X350GR','PCT',10,3500,3500,'GR','GR','10X350GR'),(1612,true,current_date,0,'PACOTE 8X160GR','PCT',8,1280,1280,'GR','GR','8X160GR'),(1613,true,current_date,0,'PACOTE 6X500GR','PCT',6,3000,3000,'GR','GR','6X500GR'),(1614,true,current_date,0,'PACOTE 25X85GR','PCT',25,2125,2125,'GR','GR','25X85GR'),(1615,true,current_date,0,'PACOTE 25X1','PCT',25,400,400,'GR','GR','25X1'),(1616,true,current_date,0,'PACOTE 18X1','PCT',18,600,600,'GR','GR','18X1'),(1617,true,current_date,0,'PACOTE 24X50GR','PCT',24,1200,1200,'GR','GR','24X50GR'),(1618,true,current_date,0,'PACOTE 12X60GR','PC ',12,720,720,'GR','GR','12X60GR'),(1619,true,current_date,0,'PACOTE 30X1','PCT',30,300,300,'GR','GR','30X1'),(1620,true,current_date,0,'PACOTE 12X200GR','PCT',12,2400,2400,'GR','GR','12X200GR'),(1621,true,current_date,0,'PACOTE 10X500ML','PCT',10,5,5,'KG','KG','10X500ML'),(1622,true,current_date,0,'PACOTE 12X300GR','PCT',12,3600,3600,'GR','GR','12X300GR'),(1623,true,current_date,0,'PACOTE 24X1','PCT',24,1500,1500,'GR','GR','24X1'),(1624,true,current_date,0,'PACOTE 12X320GR','PCT',12,3840,3840,'GR','GR','12X320GR'),(1625,true,current_date,0,'PACOTE 10X600GR','PCT',10,6000,6000,'GR','GR','10X600GR'),(1626,true,current_date,0,'PACOTE 10X300GR','PCT',10,3000,3000,'GR','GR','10X300GR'),(1627,true,current_date,0,'PACOTE 12X270GR','PCT',12,3240,3240,'GR','GR','12X270GR'),(1628,true,current_date,0,'PACOTE 12X160GR','PCT',12,1920,1920,'GR','GR','12X160GR'),(1629,true,current_date,0,'PACOTE 16X200GR','PCT',16,3200,3200,'GR','GR','16X200GR'),(1630,true,current_date,0,'PACOTE 12X260GR','PCT',12,3120,3120,'GR','GR','12X260GR'),(1631,true,current_date,0,'PACOTE 12X150ML','PCT',12,1800,1800,'GR','GR','12X150ML'),(1632,true,current_date,0,'PACOTE 6X850ML','PC ',6,5100,5100,'GR','GR','6X850ML'),(1633,true,current_date,0,'PACOTE 20X120GR','PCT',20,2400,2400,'GR','GR','20X120GR'),(1634,true,current_date,0,'CAIXA 12X30ML','CX ',12,360,360,'GR','GR','12X30ML'),(1635,true,current_date,0,'CAIXA 48X25GR','CX ',48,1200,1200,'GR','GR','48X25GR'),(1636,true,current_date,0,'CAIXA 20X40UND','CX ',20,800,800,'GR','GR','20X40UND'),(1637,true,current_date,0,'PACOTE 1X100UND','PCT',1,150,150,'GR','GR','1X100UND'),(1638,true,current_date,0,'PACOTE 16X340GR','PC ',16,5440,5440,'GR','GR','16X340GR'),(1639,true,current_date,0,'PACOTE 12X200ML','PCT',12,2400,2400,'GR','GR','12X200ML'),(1640,true,current_date,0,'PLACA 1X600GR','PL ',1,600,600,'GR','GR','1X600GR'),(1641,true,current_date,0,'PACOTE 3X80GR','PC ',3,240,240,'GR','GR','3X80GR'),(1642,true,current_date,0,'CAIXA 12X165GR','CX ',12,1980,1980,'GR','GR','12X165GR'),(1643,true,current_date,0,'PLACA 1X360GR','PL ',1,360,360,'GR','GR','1X360GR'),(1644,true,current_date,0,'PACOTE 5X200GR','PC ',5,1000,1000,'GR','GR','5X200GR'),(1645,true,current_date,0,'PACOTE 6X450GR','PC ',6,2700,2700,'GR','GR','6X450GR'),(1646,true,current_date,0,'PACOTE C/4 KG','PC ',4,4,4,'KG','KG','1X4KG'),(1647,true,current_date,0,'PACOTE 12X340GR','PCT',12,4080,4080,'GR','GR','12X340GR'),(1648,true,current_date,0,'CAIXA 48X130GR','CX ',48,6240,6240,'GR','GR','48X130GR'),(1649,true,current_date,0,'FARDO 10X12UND','FRD',10,1500,1500,'GR','GR','10X12UND'),(1650,true,current_date,0,'PACOTE 6X269ML','PC ',6,1614,1614,'GR','GR','6X269ML'),(1651,true,current_date,0,'UNIDADE 1X269ML','UND',1,269,269,'GR','GR','1X269ML'),(1652,true,current_date,0,'CAIXA 48X36GR','CX ',48,1728,1728,'GR','GR','48X36GR'),(1653,true,current_date,0,'PACOTE 18X100GR','PCT',18,1800,1800,'GR','GR','18X100GR'),(1654,true,current_date,0,'PACOTE 9X395GR','PCT',9,3555,3555,'GR','GR','9X395GR'),(1655,true,current_date,0,'UNIDADE 1X1000GR','UND',1,1000,1000,'GR','GR','1X1000GR'),(1656,true,current_date,0,'DISPLAY 1X24UND','DP ',1,0,0,'KG','KG','1X24UND'),(1657,true,current_date,0,'CAIXA 48X125GR','CX ',48,6000,6000,'GR','GR','48X125GR'),(1658,true,current_date,0,'DISPLAY 6X450GR','DP ',6,2700,2700,'GR','GR','6X450GR'),(1659,true,current_date,0,'CAIXA 10X1,01KG','CX ',10,10100,10100,'GR','GR','10X1,01KG'),(1660,true,current_date,0,'UNIDADE 1X1,01GR','UND',1,1101,1101,'GR','GR','1X1,01GR'),(1661,true,current_date,0,'CAIXA 30X3UND','CX ',30,0,0,'KG','KG','30X3UND'),(1662,true,current_date,0,'PACOTE 1X10UND','PCT',10,150,150,'GR','GR','1X10UND'),(1663,true,current_date,0,'CAIXA 12X220GR','CX ',12,2640,2640,'GR','GR','12X220GR'),(1664,true,current_date,0,'UNIDADE','UN ',1,210,210,'GR','GR','1X210G'),(1665,true,current_date,0,'UNIDADE','UN ',1,440,440,'GR','GR','1X440'),(1666,true,current_date,0,'UNIDADE','UN ',1,102,102,'GR','GR','1X102G'),(1667,true,current_date,0,'PACOTE 30X30GR','PC ',30,900,900,'GR','GR','30X30GR'),(1668,true,current_date,0,'CAIXA 20X100GR','CX ',20,2000,2000,'GR','GR','20X100GR'),(1669,true,current_date,0,'UNIDADE 1X4,6KG','UND',1,4600,4600,'KG','KG','1X4,6KG'),(1670,true,current_date,0,'PACOTE 6X150ML','PC ',6,900,900,'GR','GR','6X150ML'),(1671,true,current_date,0,'PACOTE 6X150GR','PCT',6,900,900,'GR','GR','6X150GR'),(1672,true,current_date,0,'PACOTE 6X175GR','PCT',6,1050,1050,'GR','GR','6X175GR'),(1676,true,current_date,0,'FARDO 6X26UND','FD ',6,156,156,'GR','GR','6X26UND'),(1675,true,current_date,0,'FARDO 16X9UND','FD ',16,144,144,'GR','GR','16X9UND'),(1674,true,current_date,0,'FARDO 16X8UND','FD ',16,128,128,'GR','GR','16X8UND'),(1673,true,current_date,0,'FARDO 6X20UND','FD ',20,120,120,'GR','GR','6X20UND'),(1677,true,current_date,0,'FARDO 8X18UND','FD ',8,144,144,'GR','GR','8X18UND'),(1678,true,current_date,0,'UNIDADE 1X9UND','UND',1,0,0,'KG','KG','1X9UND'),(1679,true,current_date,0,'FARDO 16X20UND','FD ',16,320,320,'GR','GR','16X20UND'),(1680,true,current_date,0,'FARDO 6X20UND','FD ',6,120,120,'GR','GR','6X20UND'),(1681,true,current_date,0,'UNIDADE 1X26UND','UND',1,26,26,'GR','GR','1X26UND'),(1682,true,current_date,0,'FARDO 4X28UND','FD ',4,112,112,'GR','GR','4X28UND'),(1683,true,current_date,0,'UNIDADE 1X28UND','UND',1,28,28,'GR','GR','1X28UND'),(1684,true,current_date,0,'CAIXA 32X350GR','CX ',32,11200,11200,'GR','GR','32X350GR'),(1685,true,current_date,0,'PACOTE 16X350GR','PCT',16,5600,5600,'GR','GR','16X350GR'),(1686,true,current_date,0,'CAIXA 48X3','CX ',48,48,0,'GR','KG','48X3'),(1687,true,current_date,0,'UNIDADE 1x3 lev 4 pg 3 ','UN ',1,35,0,'GR','KG','1X3'),(1688,true,current_date,0,'UNIDADE 1X215GR','UND',1,215,215,'GR','GR','1X215GR'),(1689,true,current_date,0,'UNIDADE 1X218GR','UND',1,218,218,'GR','GR','1X218GR'),(1690,true,current_date,0,'CAIXA 8X750GR','CX ',8,6000,6000,'GR','GR','8X750G'),(1691,true,current_date,0,'CAIXA 45X30GR','CX ',45,1350,1350,'GR','GR','45X30GR'),(1692,true,current_date,0,'CAIXA 20X80GR','CX ',20,1600,1600,'GR','GR','20X80'),(1693,true,current_date,0,'CAIXA 10X100GR','CX ',10,1000,1000,'GR','GR','10X100GR'),(1694,true,current_date,0,'UNIDADE 1X200GR','UN ',1,200,200,'GR','GR','1X200GR'),(1695,true,current_date,0,'FARDO 400X1','FD ',400,400,400,'GR','GR','400X1'),(1696,true,current_date,0,'CAXEITA 15X08GR','CXT',15,15,15,'GR','GR','15X08GR'),(1697,true,current_date,0,'UNIDADE 1X08GR','UN ',8,8,8,'GR','GR','1X8GR'),(1698,true,current_date,0,'CAIXETA 15X10GR','CXT',15,10,10,'GR','GR','15X10GR'),(1699,true,current_date,0,'UNIDADE 1X8GR','UND',1,8,8,'GR','GR','1X8GR'),(1700,true,current_date,0,'FARDO 30X200GR','FD ',200,200,200,'GR','GR','30X200GR'),(1701,true,current_date,0,'FARDO 30X200GR','FD ',30,200,200,'GR','GR','30X200GR'),(1702,true,current_date,0,'FARDO 12X8UND','FD ',12,96,96,'GR','GR','12X8UND'),(1703,true,current_date,0,'FARDO 12X7UND','FD ',12,84,84,'GR','GR','12X7UND'),(1704,true,current_date,0,'UNIDADE 1X7UND','UND',1,0,0,'GR','KG','1X7UND'),(1705,true,current_date,0,'CAIXA 40X160GR','CX ',40,6400,6400,'GR','GR','40X160GR'),(1706,true,current_date,0,'DISPLAY 21X10','DP ',21,0,0,'KG','KG','21X10'),(1707,true,current_date,0,'FARDO 6X22UN','FD ',6,0,0,'GR','GR','6X22UN'),(1708,true,current_date,0,'FARDO 16X10UN','FD ',16,0,0,'GR','GR','16X10UN'),(1709,true,current_date,0,'UNIDADE 1X22','UN ',1,0,0,'GR','GR','1X22'),(1710,true,current_date,0,'PACOTE1X14','PAC',14,224,224,'GR','GR','1X14'),(1711,true,current_date,0,'CAIXA 36X70GR','CX ',36,0,0,'GR','GR','36X70GR'),(1712,true,current_date,0,'CAIXA 12X315ML','CX ',12,315,315,'GR','GR','12X315'),(1713,true,current_date,0,'UNIDADE 1X315ML','UN ',1,315,315,'GR','GR','1X315ML'),(1714,true,current_date,0,'CAIXA 6X350G','CX ',6,2100,2150,'GR','GR','6X350'),(1715,true,current_date,0,'CAIXA 12X480G','CX ',12,5760,5800,'GR','GR','12X480G'),(1716,true,current_date,0,'CAIXA 15X25G','CX ',15,375,390,'GR','GR','15X25G'),(1717,true,current_date,0,'UNIDADE 1X3G','UND',1,3,5,'GR','GR','1X3G'),(1718,true,current_date,0,'FARDO 50X5UN','FD ',50,100,120,'GR','GR','50X5UN'),(1719,true,current_date,0,'CAIXA 90X30G','CX ',90,2700,2750,'GR','GR','90X30G'),(1720,true,current_date,0,'CAIXA 100X30G','CX ',100,3000,3050,'GR','GR','100X30G'),(1722,true,current_date,0,'UNIDADE 1X550ML','UN ',1,550,560,'GR','GR','1X550ML'),(1721,true,current_date,0,'CAIXA 12X550ML','CX ',12,6600,6610,'GR','GR','12X550ML'),(1723,true,current_date,0,'DUZIA 12X150G','DZ ',12,1800,1900,'GR','GR','12X150G'),(1724,true,current_date,0,'PACOTE 12X510ML','PCT',12,6120,6130,'GR','GR','12X510ML'),(1725,true,current_date,0,'BANDEJA 8X45G','BJ ',8,360,370,'GR','GR','8X45G'),(1726,true,current_date,0,'PACOTE 6X25G','PC ',6,150,160,'GR','GR','6X25G'),(1727,true,current_date,0,'CAIXA 8X650G','CX ',8,5200,5300,'GR','GR','8X650G'),(1728,true,current_date,0,'PACOTE 6X830','PC ',6,830,0,'KG','KG','6X830'),(1729,true,current_date,0,'PACOTE 6X30ML','PCT',6,30,0,'KG','KG','6X30ML'),(1730,true,current_date,0,'CAIXA 68X10GR','CX ',68,680,685,'GR','GR','68X10GR'),(1731,true,current_date,0,'CAIXA 6X1L','CX ',6,6000,6150,'GR','GR','6X1L'),(1732,true,current_date,0,'CAIXA 6X1,5L','CX ',6,9000,9150,'GR','GR','6X1,5L'),(1733,true,current_date,0,'CAIXA 12X660ML','CX ',12,7920,8000,'GR','GR','12X660ML'),(1734,true,current_date,0,'UNIDADE 1X660ML','UN ',1,660,750,'GR','GR','1X660ML'),(1735,true,current_date,0,'PACOTE 6X90G','PC ',6,540,560,'GR','GR','6X90G'),(1736,true,current_date,0,'PACOTE 12X355ML','PCT',12,4260,4300,'GR','GR','12X355ML'),(1737,true,current_date,0,'CAIXA 6X2,55KG','CX ',6,1530,1530,'GR','GR','6X2,55KG'),(1738,true,current_date,0,'LATA 1X2,55KG','LT ',1,2550,2550,'GR','GR','1X2,55KG'),(1739,true,current_date,0,'BALDE C/14KG','BD ',14,14,14,'KG','KG','14KG'),(1740,true,current_date,0,'DISPLAY 15X60GR','DP ',15,900,900,'GR','GR','15X60GR'),(1741,true,current_date,0,'DISPLAY 24X25GR','DP ',24,600,600,'GR','GR','24X25GR'),(1742,true,current_date,0,'UNIDADE 1X25GR','UND',1,25,25,'GR','GR','1X25GR'),(1743,true,current_date,0,'UNIDADE 1X4,5','UND',1,4,0,'GR','GR','1X4,5'),(1744,true,current_date,0,'DISPLAY 1X40GR','DP ',1,40,40,'GR','GR','1X40GR'),(1745,true,current_date,0,'CAIXA 28X120G','CX ',28,3360,3400,'GR','GR','28X120G'),(1746,true,current_date,0,'PACOTE','PC ',3,0,0,'GR','GR','0'),(1747,true,current_date,0,'PACOTE 4X3','PC ',4,120,125,'GR','GR','4X3'),(1748,true,current_date,0,'CAIXA 5X1KG','CX ',5,5,5,'KG','KG','5X1KG'),(1749,true,current_date,0,'UNIDADE 1X5,1L','UND',1,5100,5100,'GR','GR','1X5,1L'),(1750,true,current_date,0,'UNIDADE 1X3L','UND',1,3000,3000,'GR','GR','1X3L'),(1751,true,current_date,0,'CAIXETA 21X8G','CXT',21,168,170,'GR','GR','21X8G'),(1752,true,current_date,0,'PACOTE 6X26G','PCT',6,156,156,'GR','GR','6X26GR'),(1753,true,current_date,0,'PACOTE 1X12UND','PCT',1,0,0,'KG','KG','1X12UND'),(1766,true,current_date,0,'CAIXA 15X50UN','CX ',15,750,800,'GR','GR','15X50'),(1754,true,current_date,0,'FARDO 50X12','FD ',50,0,0,'KG','KG','50X12'),(1755,true,current_date,0,'UNIDADE 1X16G','UND',1,16,16,'GR','GR','1X16G'),(1756,true,current_date,0,'CAIXA 25X500GR','CX ',25,12500,12500,'GR','GR','25X500GR'),(1757,true,current_date,0,'BALDE 1X1,005KG','BLD',1,1005,1005,'KG','KG','1X1,005KG'),(1758,true,current_date,0,'BALDE 1X400GR','BLD',1,400,400,'GR','GR','1X400GR'),(1759,true,current_date,0,'PACOTE 6X355ML','PCT',6,1278,1278,'GR','GR','6X355ML'),(1760,true,current_date,0,'CAIXA C/10KG','CX ',10,10,10,'KG','KG','10X1'),(1761,true,current_date,0,'DISPLAY 1X300GR','DP ',1,300,300,'GR','GR','1X300GR'),(1762,true,current_date,0,'CAIXA 16X125GR','CX ',16,2000,2100,'GR','GR','16X125G'),(1763,true,current_date,0,'UNIDADE 1X440G','UND',1,440,440,'GR','GR','1X440G'),(1767,true,current_date,0,'PACOTE 12X130G','PCT',12,1560,1560,'GR','GR','12X130G'),(1768,true,current_date,0,'KIT 2X100G','KT ',2,200,200,'GR','GR','100G'),(1769,true,current_date,0,'CAIXA 6X2,85KG','CX ',6,1700,1710,'GR','GR','6X2,85'),(1770,true,current_date,0,'UNIDADE 1X2,85KG','UND',1,285,290,'GR','GR','1X2,85'),(1771,true,current_date,0,'CAIXA 12X1,01KG','CX ',12,1212,1215,'GR','GR','12X1,01'),(1772,true,current_date,0,'UNIDADE 1X1,01KG','UND',1,101,105,'GR','GR','1X1,01'),(1773,true,current_date,0,'CAIXA 1X1134KG','CX ',1,1134,1140,'GR','GR','1X1134'),(1774,true,current_date,0,'PACOTE 6X2.5L','PCT',6,0,0,'KG','KG','6X2.5L'),(1775,true,current_date,0,'FARDO 10X160G','FD ',10,1600,1600,'GR','GR','10X160G'),(1776,true,current_date,0,'CAIXA 6X1,01KG','CX ',6,6060,6060,'KG','KG','6X1,01KG'),(1777,true,current_date,0,'CAIXA 10X475G','CX ',10,475,475,'GR','GR','10X475G'),(1778,true,current_date,0,'UNIDADE 1X475G','UND',1,475,475,'GR','GR','1X475G'),(1779,true,current_date,0,'UNIDADE 1X45ML','UND',1,0,0,'KG','KG','1X45ML'),(1780,true,current_date,0,'PACOTE 1X600G','PCT',1,600,600,'GR','GR','1X600G'),(1781,true,current_date,0,'CAIXA 6X20UND','CX ',6,0,0,'KG','KG','6X20UND'),(1782,true,current_date,0,'CAIXA 6X24UND','CX ',6,0,0,'KG','KG','6X24UND'),(1783,true,current_date,0,'DISPLAY 14X24G','DP ',14,336,336,'GR','GR','14X24G'),(1784,true,current_date,0,'DISPLAY 12X22G','DP ',12,264,264,'GR','GR','12X22G'),(1785,true,current_date,0,'DISPLAY 3X22G','DP ',3,66,66,'GR','GR','3X22G'),(1786,true,current_date,0,'CAIXA 63X140G','CX ',63,8820,8820,'GR','GR','63X140G'),(1787,true,current_date,0,'PACOTE 4X28GR','PC ',4,112,115,'GR','GR','4X28G'),(1789,true,current_date,0,'PACOTE 40X100G','PCT',40,400,500,'GR','GR','40X100G'),(1790,true,current_date,0,'CAIXA 18X1,1KG','CX ',18,19800,19800,'GR','GR','18X1.1KG'),(1791,true,current_date,0,'DISPLAY 12X57G','DP ',12,114,116,'GR','GR','12X57G'),(1792,true,current_date,0,'PACOTE 6X3,2KG','PCT',6,19200,19200,'GR','GR','6X3,2KG'),(1793,true,current_date,0,'CAIXA 176X6G','CX ',176,1056,1056,'GR','GR','176X6G'),(1794,true,current_date,0,'CAIXA 152X7G','CX ',152,1064,1064,'GR','GR','152X7G'),(1795,true,current_date,0,'CAIXA 80X114G','CX ',80,9000,9000,'GR','GR','80X114G'),(1797,true,current_date,0,'CAIXA 12X118G','CX ',12,1416,1420,'GR','GR','12X118'),(1798,true,current_date,0,'UNIDADE 1X118G','UN ',1,118,118,'GR','GR','1X118G'),(1799,true,current_date,0,'CAIXA 12X840G','CX ',12,10080,10080,'GR','GR','12X840G'),(1800,true,current_date,0,'UNIDADE 1X840G','UND',1,840,840,'GR','GR','1X840G'),(1801,true,current_date,0,'CAIXA 40X96G','CX ',40,3840,3840,'GR','GR','40X96GR'),(1802,true,current_date,0,'CAIXA 40X99G','CX ',40,3960,3960,'GR','GR','40X99G'),(1803,true,current_date,0,'UNIDADE 1X96GR','UND',1,96,96,'GR','GR','1X96GR'),(1804,true,current_date,0,'UNIDADE 1X99GR','UND',1,99,99,'GR','GR','1X99G'),(1805,true,current_date,0,'CAIXA 12X175G','CX ',12,2100,2100,'GR','GR','12X175G'),(1806,true,current_date,0,'PACOTE 6X70G','PCT',6,420,425,'GR','GR','6X70G'),(1807,true,current_date,0,'UNIDADE 1X23GR','UND',1,23,23,'GR','GR','1X23G'),(1808,true,current_date,0,'CAIXA 36X12G','CX ',36,432,440,'GR','GR','36X12G'),(1809,true,current_date,0,'UNIDADE 1X12G','UND',1,12,15,'GR','GR','1X12G'),(1810,true,current_date,0,'COMBO 5X500G','CB ',5,2500,2600,'GR','GR','5X500G'),(1811,true,current_date,0,'COMBO 1X5','CB ',1,5,5,'GR','GR','1X5'),(1812,true,current_date,0,'CAIXA 12X325G','CX ',12,3900,3950,'GR','GR','12X325G'),(1813,true,current_date,0,'CAIXA 24X3G','CX ',24,72,75,'GR','GR','24X3G'),(1814,true,current_date,0,'CAIXA 20X375G','CX ',20,7500,7500,'GR','GR','20X375G'),(1815,true,current_date,0,'PACOTE 10X15UN','PCT',10,150,150,'GR','GR','10X15UN'),(1816,true,current_date,0,'UNIDADE 1X15UN','UND',1,50,50,'GR','GR','1X15UN'),(1817,true,current_date,0,'DISPLAY 6X2','DSP',6,100,110,'GR','GR','6'),(1818,true,current_date,0,'CAIXETA 15X90G','CXT',15,140,140,'GR','GR','15X90G'),(1819,true,current_date,0,'FARDO 8X20UND','UND',8,300,300,'GR','GR','8X20UND'),(1820,true,current_date,0,'FARDO 12X22UND','FD ',12,300,300,'GR','GR','12X22UND'),(1821,true,current_date,0,'FARDO 20X8UND','FD ',20,300,300,'GR','GR','20X8UND'),(1822,true,current_date,0,'FARDO 20X9UND','FD ',20,300,300,'GR','GR','20X9UND'),(1823,true,current_date,0,'BALDE C/15KG','BD ',15,15,15,'KG','KG','BALDE C/15'),(1824,true,current_date,0,'CAIXA 50X170G','CX ',50,8500,8500,'GR','GR','50X170G'),(1825,true,current_date,0,'CAIXA 27X400G','CX ',27,10800,10800,'GR','GR','27X400G'),(1826,true,current_date,0,'CAIXA 24X240G','CX ',24,5760,5760,'GR','GR','24X240G'),(1827,true,current_date,0,'LATA 1X10KG','LT ',1,1000,1000,'GR','GR','1X10KG'),(1828,true,current_date,0,'CAIXA 36X170G','CX ',36,6120,6120,'GR','GR','36X170G'),(1829,true,current_date,0,'CAIXA 12X630ML','CX ',12,7560,7560,'GR','GR','12X630ML'),(1830,true,current_date,0,'UNIDADE 1X630ML','UND',1,630,630,'GR','GR','1X630ML'),(1831,true,current_date,0,'CAIXA 19X200G','CX ',19,3800,3800,'GR','GR','19X200G'),(1832,true,current_date,0,'FARDO C/5KG','FD ',5,5,5,'KG','KG','5KG'),(1833,true,current_date,0,'PACOTE 6X5UND','PCT',6,0,0,'KG','KG','6X5UND'),(1834,true,current_date,0,'FARDO 24X20UN','FD ',20,480,480,'GR','GR','24X20UN'),(1835,true,current_date,0,'FARDO 12X100un','FD ',12,1200,1200,'GR','GR','12X100'),(1836,true,current_date,0,'FARDO 12X25un','FD ',12,300,300,'GR','GR','12X25'),(1837,true,current_date,0,'UNIDADE 1X25','UN ',1,25,25,'GR','GR','1X25'),(1838,true,current_date,0,'CAIXA 24X290ML','CX ',24,6960,6960,'GR','GR','24X290ML'),(1840,true,current_date,0,'PACOTE 48X200ML','PCT',48,9600,9600,'GR','GR','48X200ML'),(1839,true,current_date,0,'PACOTE 6X1,5L','PCT',6,9,9,'GR','GR','6X1,5L'),(1841,true,current_date,0,'UNIDADE 1X290ML','UND',1,0,0,'KG','KG','1X290ML'),(1842,true,current_date,0,'FARDO 10X120G','FD ',10,1200,1200,'GR','GR','10X120G'),(1843,true,current_date,0,'FARDO 6X10UN','FD ',6,2000,2000,'GR','GR','6X10UN'),(1844,true,current_date,0,'FARDO C/20','FD ',20,0,0,'KG','KG','20X14CM'),(1845,true,current_date,0,'CAIXA 1X23KG','CX ',1,23,23,'KG','KG','1X23KG'),(1846,true,current_date,0,'PACOTE 6X100G','PCT',6,600,600,'GR','GR','6X100G'),(1848,true,current_date,0,'UNIDADE 1X123G','UND',1,123,123,'GR','GR','1X123G'),(1847,true,current_date,0,'CAIXA 40X123G','CX ',40,4920,4920,'GR','GR','40X123G'),(1849,true,current_date,0,'CAIXETA 26X3g','CXT',26,78,78,'GR','GR','26X3G'),(1850,true,current_date,0,'KIT 1X1','KIT',1,0,0,'KG','KG','1X1'),(1851,true,current_date,0,'UNIDADE 1X42G','UND',1,42,42,'GR','GR','1X42G'),(1852,true,current_date,0,'FARDO 36X200G','FD ',36,7200,7200,'GR','GR','36X200G'),(1853,true,current_date,0,'PACOTE 12X500G','PCT',12,6000,6000,'GR','GR','12X500'),(1854,true,current_date,0,'CAIXA 12X306G','CX ',12,3672,3672,'GR','GR','12X306G'),(1855,true,current_date,0,'UNIDADE 1X306G','UND',1,306,306,'GR','GR','1X306G'),(1856,true,current_date,0,'CAIXETA 1X400G','CXT',1,400,400,'GR','GR','1X400G'),(1857,true,current_date,0,'PACOTE 6X380G','PCT',6,2280,2280,'GR','GR','6X380G'),(1858,true,current_date,0,'UNIDADE 1X89G','UND',1,89,89,'GR','GR','1X89G'),(1859,true,current_date,0,'UNIDADE 1X33G','UND',1,33,33,'GR','GR','1X33G'),(1860,true,current_date,0,'UNIDADE 1,2KG','UND',1,1200,1200,'GR','GR','1,2KG'),(1861,true,current_date,0,'CAIXA 12X220ML','CX ',12,0,0,'GR','GR','12X220ML'),(1862,true,current_date,0,'BALDE 3,6KG','BD ',1,3600,3650,'GR','GR','1X3,6KG'),(1863,true,current_date,0,'CAIXA 24X63G','CX ',24,1512,1512,'GR','GR','24X63G'),(1864,true,current_date,0,'UNIDADE 1X220ML','UND',1,0,0,'KG','KG','1X220ML'),(1865,true,current_date,0,'DISPLAY 32X20G','DP ',32,640,640,'GR','GR','32X20G'),(1866,true,current_date,0,'CONJUNTO 1X3PC','CJ ',3,2000,2000,'GR','GR','1X3PC'),(1867,true,current_date,0,'CONJUNTO 1X36PC','CJ ',36,2000,2000,'GR','GR','1X36PC'),(1868,true,current_date,0,'CONJUNTO 1X10PC','CJ ',10,1000,1000,'GR','GR','1X10PC'),(1869,true,current_date,0,'PACOTE 12X25GR','PCT',12,300,300,'GR','GR','12X25G'),(1870,true,current_date,0,'CAIXA 2X4,5L','CX ',2,0,0,'GR','GR','2X4,5L'),(1871,true,current_date,0,'CAIXA 12X295ML','CX ',12,3540,3540,'GR','GR','12X295ML'),(1872,true,current_date,0,'UNIDADE 1X295ML','UND',1,0,0,'GR','GR','1X295ML'),(1873,true,current_date,0,'UNIDADE 1X4,5L','UND',1,4500,4500,'GR','GR','1X4,5L'),(1874,true,current_date,0,'CAIXA 24X8UND','CX ',24,0,0,'KG','KG','24X8UND'),(1875,true,current_date,0,'DISPLAY 10X16UND','DP ',10,0,0,'KG','KG','10X16UND'),(1876,true,current_date,0,'PACOTE 9X50UND','PCT',9,0,0,'KG','KG','9X50UND'),(1877,true,current_date,0,'UNIDADE 1X16UND','UND',1,0,0,'KG','KG','1X16UND'),(1878,true,current_date,0,'DUZIA 12X84G','DZ ',12,1008,1008,'GR','GR','12X84G'),(1879,true,current_date,0,'CAIXETA 10X130G','CXT',10,1300,1350,'GR','GR','10X130G'),(1880,true,current_date,0,'UNIDADE 1X84G','UND',1,84,84,'GR','GR','1X84G'),(1881,true,current_date,0,'CAIXA 12X152ML','CX ',12,1824,1824,'GR','GR','12X152ML'),(1882,true,current_date,0,'UNIDADE 1X152ML','UND',1,1520,1520,'GR','GR','1X152ML'),(1883,true,current_date,0,'PACOTE 4X26G','PCT',4,104,110,'GR','GR','4X26G'),(1884,true,current_date,0,'CAIXA 6X500un','CX ',6,1000,1000,'GR','GR','6X500UN'),(1885,true,current_date,0,'UNIDADE 1X500','UND',1,500,500,'GR','GR','1X500'),(1886,true,current_date,0,'CAIXETA 12X56G','CXT',12,672,680,'GR','GR','12X56G'),(1887,true,current_date,0,'CAIXA 42X49G','CX ',42,2058,2058,'GR','GR','42X49G'),(1888,true,current_date,0,'CAIXA 48X110G','CX ',48,5280,5300,'GR','GR','48X110G'),(1889,true,current_date,0,'CAIXA 55X140G','CX ',55,7700,7750,'GR','GR','55X140G'),(1890,true,current_date,0,'CAIXA 24X111G','CX ',24,2664,2664,'GR','GR','24X111G'),(1891,true,current_date,0,'UNIDADE 1X111G','UND',1,111,111,'GR','GR','1X111G'),(1892,true,current_date,0,'PACOTE 1X6un','PCT',6,300,350,'GR','GR','1X6UN'),(1893,true,current_date,0,'CAIXA 20X400ML','CX ',20,8000,8000,'GR','GR','20X400ML'),(1894,true,current_date,0,'DISPLAY 14X16G','DP ',14,224,224,'GR','GR','14X16G'),(1895,true,current_date,0,'PACOTE 4X3L','PCT',4,1200,1250,'GR','GR','4X3L'),(1896,true,current_date,0,'BALDE 1X1,2KG','BD ',1,1200,1200,'GR','GR','1X1,2KG'),(1897,true,current_date,0,'DISPLAY 68X10G','DP ',68,680,685,'GR','GR','68X10G'),(1898,true,current_date,0,'DISPLAY 16X125G','DP ',16,2000,2010,'GR','GR','16X125G'),(1899,true,current_date,0,'CAIXA 12X80ML','CX ',12,960,965,'GR','GR','12X80ML'),(1900,true,current_date,0,'FARDO 4X16','FD ',4,1500,1600,'GR','GR','4X16'),(1901,true,current_date,0,'PACOTE 1X16','PCT',1,500,500,'GR','GR','1X16'),(1902,true,current_date,0,'CAIXA 20X12UND','CX ',20,72,75,'GR','GR','20X12UND'),(1903,true,current_date,0,'PACOTE 50X90G','PCT',50,450,500,'GR','GR','50X90G'),(1904,true,current_date,0,'CAIXETA 12X56G','CXT',12,672,680,'GR','GR','12X56G'),(1905,true,current_date,0,'CAIXA 12X275ML','CX ',12,3300,3300,'GR','GR','12X275ML'),(1906,true,current_date,0,'UNIDADE 1X275ML','UND',1,275,280,'GR','GR','1X275ML'),(1907,true,current_date,0,'FARDO 12X1KG','FD ',12,1200,1210,'GR','GR','12X1KG'),(1908,true,current_date,0,'CAIXA 30X12UND','CX ',30,3600,4000,'GR','GR','30X12UND'),(1909,true,current_date,0,'CAIXETA 12X170G','CXT',12,2040,2100,'GR','GR','12X170G'),(1910,true,current_date,0,'UNIDADE 1X1,2KG','UND',1,1200,1200,'GR','GR','1X1,2KG'),(1911,true,current_date,0,'CAIXETA 24X30G','CXT',24,720,800,'GR','GR','24X30G'),(1912,true,current_date,0,'CAIXETA 30X28G','CXT',30,840,890,'GR','GR','30X28G'),(1913,true,current_date,0,'UNIDADE 1X28G','UND',1,28,30,'GR','GR','1X28G'),(1914,true,current_date,0,'DISPLAY 28X20G','DP ',28,560,560,'GR','GR','28X20G'),(1915,true,current_date,0,'CAIXA 5X2,5KG','CX ',5,12500,12510,'GR','GR','5X2,5KG'),(1916,true,current_date,0,'CAIXA 72X180G','CX ',72,12960,12970,'GR','GR','72X180G'),(1917,true,current_date,0,'CAIXA 36X90G','CX ',36,3240,3240,'GR','GR','36X90G'),(1918,true,current_date,0,'FARDO 5X5KG','FD ',5,25,25,'KG','KG','5X5KG'),(1919,true,current_date,0,'FARDO 5KG','FD ',1,5,5,'KG','KG','1X5KG'),(1920,true,current_date,0,'CAIXA 16X450G','CX ',16,7200,7250,'GR','GR','16X450G'),(1921,true,current_date,0,'CAIXA 18X145G','CX ',18,3000,3010,'GR','GR','18X145G'),(1922,true,current_date,0,'CAIXA 3X5L','CX ',3,1500,1520,'GR','GR','3X5L'),(1923,true,current_date,0,'FARDO 4X12','FD ',4,1000,1000,'GR','GR','4X12'),(1924,true,current_date,0,'UNIDADE 1X202GR','UND',1,202,202,'GR','GR','1X202GR'),(1925,true,current_date,0,'CAIXA 20X900GR','CX ',20,18000,18000,'GR','GR','20X900GR'),(1926,true,current_date,0,'CAIXA 6X240G','CX ',6,1440,1450,'GR','GR','6X240G'),(1927,true,current_date,0,'CAIXA 6X320G','CX ',6,1920,1930,'GR','GR','6X320G'),(1928,true,current_date,0,'CAIXA 3X200ML','CX ',3,0,0,'KG','KG','3X200ML'),(1929,true,current_date,0,'PACOTE 100X50G','PCT',100,5000,5000,'GR','GR','100X50G'),(1930,true,current_date,0,'CAIXA 30X1KG','CX ',30,3000,3010,'GR','GR','30X1KG'),(1931,true,current_date,0,'UNIDADE 1X18g','UND',1,18,20,'GR','GR','1X18G'),(1932,true,current_date,0,'POTE 1X40UND','PT ',40,0,0,'KG','KG','40UND'),(1933,true,current_date,0,'CAIXA 12X650ML','CX ',12,0,0,'KG','KG','12X650ML'),(1934,true,current_date,0,'UNIDADE 1X650ML','UND',1,0,0,'KG','KG','1X650ML'),(1935,true,current_date,0,'CAIXA 4X2,8KG','CX ',4,11200,11300,'GR','GR','4X2,8KG'),(1936,true,current_date,0,'UNIDADE 1X2,8KG','UND',1,2800,2850,'GR','GR','1X2,8KG'),(1937,true,current_date,0,'CAIXA 5X2KG','CX ',5,10000,10000,'GR','GR','5X2KG'),(1938,true,current_date,0,'CAIXA 8X540G','CX ',8,4320,4320,'GR','GR','8X540G'),(1939,true,current_date,0,'CAIXA 4X500ML','CX ',4,2000,2000,'GR','GR','4X500ML'),(1940,true,current_date,0,'CX 2X5L','CX ',2,10000,10000,'GR','GR','2X5L'),(1941,true,current_date,0,'CAIXA 12X185GR','CX ',12,2220,2220,'GR','GR','12X185GR'),(1942,true,current_date,0,'CAIXA 35X250G','CX ',35,8750,8750,'GR','GR','35X250G'),(1943,true,current_date,0,'CAIXA 48X37,5GR','CX ',48,1800,1800,'GR','GR','48X37,5GR'),(1944,true,current_date,0,'UNIDADE 1X37,5G','UND',1,38,38,'GR','GR','1X37,5G'),(1945,true,current_date,0,'CAIXA 40X114g','CX ',40,4560,4560,'GR','GR','40X114G'),(1946,true,current_date,0,'DISPLAY 12X40GR','DP ',12,480,480,'GR','GR','12X40G'),(1947,true,current_date,0,'CAIXA 15X170G','CX ',15,2550,2560,'GR','GR','15X170G'),(1948,true,current_date,0,'PACOTE 30X10G','PCT',30,300,310,'GR','GR','30X10G'),(1949,true,current_date,0,'PACOTE 30X20G','PCT',30,600,610,'GR','GR','30X20G'),(1950,true,current_date,0,'PACOTE 30X5G','PCT',30,150,160,'GR','GR','30X5G'),(1951,true,current_date,0,'PACOTE 30X6G','PCT',30,180,190,'GR','GR','30X6G'),(1952,true,current_date,0,'PACOTE 30X2UNID','UND',30,100,110,'GR','GR','30X2UNID'),(1953,true,current_date,0,'UNIDADE 1X5G','UND',1,5,6,'GR','GR','1X5G'),(1954,true,current_date,0,'UNIDADE 1X2UND','UND',1,20,25,'GR','GR','1X2UND'),(1955,true,current_date,0,'UNIDADE 1X245G','UND',1,245,245,'GR','GR','1X245GR'),(1956,true,current_date,0,'DISPLAY 25X22G','DP ',25,55,55,'GR','GR','25X22G'),(1957,true,current_date,0,'CAIXA 16X200G','CX ',16,3200,3200,'GR','GR','16X200GR'),(1958,true,current_date,0,'CAIXA 12X187ML','CX ',12,2244,2244,'GR','GR','12X187ML'),(1959,true,current_date,0,'UNIDADE 1X187ML','UND',1,187,187,'GR','GR','1X187ML'),(1960,true,current_date,0,'FARDO 5X1600G','FD ',5,8,8,'KG','KG','5X1600G'),(1961,true,current_date,0,'UNIDADE 1X1600G','UND',1,1600,1600,'GR','GR','1X1600G'),(1962,true,current_date,0,'CAIXA 6X1,55kg','CX ',6,9300,9300,'GR','GR','6X1,55KG'),(1963,true,current_date,0,'CAIXA 6X270ML','CX ',6,1620,1630,'GR','GR','6X270ML'),(1964,true,current_date,0,'UNIDADE 1X270ML','UND',1,270,275,'GR','GR','1X270ML'),(1965,true,current_date,0,'UNIDADE 1X1,55kg','UND',1,1550,1550,'GR','GR','1X1,55KG'),(1966,true,current_date,0,'CAIXA 16X250G','CX ',16,4000,4000,'GR','GR','16X250G'),(1967,true,current_date,0,'PACOTE 24X8G','PCT',24,192,193,'GR','GR','24X8G'),(1968,true,current_date,0,'PACOTE 1X8UN','PCT',1,100,100,'GR','GR','1X8UND'),(1969,true,current_date,0,'CAIXA 400X5g','CX ',400,2,2,'KG','KG','400X5G'),(1970,true,current_date,0,'CAIXA 400X2,5g','CX ',400,1,1,'KG','KG','400X2,5G'),(1971,true,current_date,0,'UNIDADE 1X151G','UND',1,151,155,'GR','GR','1X151G'),(1972,true,current_date,0,'PACOTE 25X109g','PCT',25,2725,2725,'GR','GR','25X109'),(1973,true,current_date,0,'UNIDADE 1X2KG','UND',1,2000,2100,'GR','GR','1X2KG'),(1974,true,current_date,0,'CAIXA 6X475ml','CX ',6,2850,2850,'GR','GR','6X475ML'),(1975,true,current_date,0,'CAIXA 6X1,25kg','CX ',6,7500,7500,'GR','GR','6X1,25KG'),(1976,true,current_date,0,'UNIDADE 1X1,25kg','UND',1,1250,1250,'GR','GR','1X1,25G'),(1977,true,current_date,0,'UNIDADE 1X475ml','UND',1,475,475,'GR','GR','1X475ML'),(1978,true,current_date,0,'CAIXA 20X50und','CX ',20,0,0,'KG','KG','20X50UND'),(1979,true,current_date,0,'CAIXA 20X100und','CX ',20,0,0,'KG','KG','20X100UND'),(1980,true,current_date,0,'CAIXA 100X10und','CX ',1000,0,0,'KG','KG','100X10UND'),(1981,true,current_date,0,'CAIXA 100X10und','CX ',100,0,0,'KG','KG','100X10UND'),(1982,true,current_date,0,'FARDO 4X5KG','FD ',4,20000,20000,'GR','GR','4X5KG'),(1983,true,current_date,0,'FARDO 6X3KG','FD ',6,18000,18000,'GR','GR','6X3KG'),(1984,true,current_date,0,'FARDO 20X1KG','FD ',20,20000,20000,'GR','GR','20X1KG'),(1985,true,current_date,0,'UNIDADE 1X5KG','UND',1,5000,5000,'GR','GR','1X5KG'),(1986,true,current_date,0,'CAIXA 24X400ml','CX ',24,9600,9600,'GR','GR','24X400ML'),(1987,true,current_date,0,'DISPLAY 12X130g','DP ',12,1560,1560,'GR','GR','12X130G'),(1989,true,current_date,0,'CONJUNTO 1X3UND','CJ ',1,50,50,'GR','GR','1X3UND'),(1988,true,current_date,0,'CAIXA 12X3UND','CX ',12,1200,1200,'GR','GR','12X3UND'),(1990,true,current_date,0,'DISPLAY 12X110G','DP ',12,1320,1320,'GR','GR','12X110G'),(1991,true,current_date,0,'DISPLAY 6X115g','DP ',6,690,690,'GR','GR','6X115G'),(1992,true,current_date,0,'DISPLAY 24X30g','DP ',24,720,720,'GR','GR','24X30G'),(1993,true,current_date,0,'CAIXA 180x8g','CX ',180,1440,1440,'GR','GR','180X8G'),(1994,true,current_date,0,'UNIDADE 1X570G','UND',1,570,575,'GR','GR','1X570G'),(1995,true,current_date,0,'FARDO 12X100g','FD ',12,1200,1200,'GR','GR','12X100G'),(1996,true,current_date,0,'CAIXA 12X305g','CX ',12,3660,3660,'GR','GR','12X305G'),(1997,true,current_date,0,'CAIXA 12X345g','CX ',12,4140,4140,'GR','GR','12X345G'),(1998,true,current_date,0,'CAIXA 12X124g','CX ',12,1488,1488,'GR','GR','12X124G'),(1999,true,current_date,0,'UNIDADE 1X305g','UND',1,305,305,'GR','GR','1X305G'),(2000,true,current_date,0,'UNIDADE 1X345g','UND',1,345,345,'GR','GR','1X345G'),(2001,true,current_date,0,'UNIDADE 1X124g','UND',1,124,124,'GR','GR','1X124G'),(2002,true,current_date,0,'CAIXA 16X397G','CX ',16,6352,6360,'GR','GR','16X397G'),(2003,true,current_date,0,'CAIXA 16X255G','CX ',16,4080,4100,'GR','GR','16X255G'),(2004,true,current_date,0,'UNIDADE 1X397G','UND',1,397,397,'GR','GR','1X397G'),(2005,true,current_date,0,'UNIDADE 1X255G','UND',1,255,255,'GR','GR','1X255G'),(2006,true,current_date,0,'CAIXA C/24 kg','CX ',24,24,24,'KG','KG','1X24KG'),(2007,true,current_date,0,'DISPLAY 10X100g','DP ',10,1000,1100,'GR','GR','10X100G'),(2008,true,current_date,0,'DISPLAY 18X25g','DP ',18,450,460,'GR','GR','18X25G'),(2009,true,current_date,0,'CAIXA 150X1','CX ',150,0,0,'GR','GR','150X1'),(2010,true,current_date,0,'PACOTE 21X200g','PCT',21,4200,4250,'GR','GR','21X200G'),(2011,true,current_date,0,'FARDO 20X10UN','FD ',20,3000,3000,'GR','GR','20X10UN'),(2012,true,current_date,0,'CAIXA 32X140g','CX ',32,140,140,'GR','GR','32X140G'),(2013,true,current_date,0,'CAIXA 15X800g','CX ',15,12000,12000,'GR','GR','15X800G'),(2014,true,current_date,0,'DISPLAY 16X60g','DP ',16,960,960,'GR','GR','16X60G'),(2015,true,current_date,0,'PACOTE 3X160G','PCT',3,480,490,'GR','GR','3X160G'),(2016,true,current_date,0,'UNIDADE 1X210G','UND',1,210,220,'GR','GR','1X210G'),(2017,true,current_date,0,'CAIXETA 24X21G','CXT',24,504,510,'GR','GR','24X21G'),(2018,true,current_date,0,'CAIXA 152X6G','CX ',152,900,950,'GR','GR','152X6G'),(2019,true,current_date,0,'PACOTE 50X20G','PCT',50,1000,1100,'GR','GR','50X20G'),(2020,true,current_date,0,'DISPLAY 20X25g','DP ',20,500,500,'GR','GR','20X25G'),(2021,true,current_date,0,'CAIXA 4X2,5KG','CX ',4,2500,2550,'GR','GR','4X2,5KG'),(2022,true,current_date,0,'PACOTE 5X100g','PCT',5,500,500,'GR','GR','5X100G'),(2023,true,current_date,0,'DISPLAY 15X6g','DSP',15,90,90,'GR','GR','15X6G'),(2024,true,current_date,0,'UNIDADE 1X6g','UND',1,6,6,'GR','GR','1X6G'),(2025,true,current_date,0,'PACOTE 20X200g','PCT',20,4000,4000,'GR','GR','20X200G'),(2026,true,current_date,0,'CAIXA 42X110G','CX ',42,4620,4630,'GR','GR','42X110G'),(2027,true,current_date,0,'CAIXA 20X419G','CX ',20,8380,8390,'GR','GR','20X419G'),(2028,true,current_date,0,'CAIXA 36X162G','CX ',36,5832,5840,'GR','GR','36X162G'),(2029,true,current_date,0,'CAIXA 42X105,6G','CX ',42,4435,4440,'GR','GR','42X105,6G'),(2030,true,current_date,0,'CAIXA 36X168G','CX ',36,6048,6050,'GR','GR','36X168G'),(2031,true,current_date,0,'UNIDADE 1X419G','UND',1,419,425,'GR','GR','1X419G'),(2032,true,current_date,0,'UNIDADE 1X162G','UND',1,162,165,'GR','GR','1X162G'),(2033,true,current_date,0,'UNIDADE 1X105,6g','UND',1,106,106,'GR','GR','1X105,6G'),(2034,true,current_date,0,'UNIDADE 1X168G','UND',1,168,170,'GR','GR','1X168G'),(1283,true,current_date,0,'BANDEJA 1KG','BD ',1,1000,1000,'GR','GR','1X1KG'),(2035,true,current_date,0,'DISPLAY 24X18g','DP ',24,432,432,'GR','GR','24X18G'),(2036,true,current_date,0,'DISPLAY 24X17g','DP ',24,408,408,'GR','GR','24X17G'),(2037,true,current_date,0,'UNIDADE 1X17g','UND',1,17,17,'GR','GR','1X17G'),(2038,true,current_date,0,'DISPLAY 12X160g','DP ',12,1920,1920,'GR','GR','12X160G'),(2039,true,current_date,0,'DISPLAY 20X48g','DP ',20,960,960,'GR','GR','20X48G'),(2040,true,current_date,0,'DISPLAY 7X40g','DP ',7,280,280,'GR','GR','7X40G'),(2041,true,current_date,0,'DISPLAY 15X25g','DP ',15,375,375,'GR','GR','15X25G'),(2042,true,current_date,0,'DISPLAY 12X100g','DP ',12,1200,1200,'GR','GR','12X100G'),(2043,true,current_date,0,'DISPLAY 12X76g','DP ',12,912,912,'GR','GR','12X76G'),(2044,true,current_date,0,'DISPLAY 40X17g','DP ',40,680,680,'GR','GR','40X17G'),(2045,true,current_date,0,'UNIDADE 1X76g','UND',1,76,76,'GR','GR','1X76G'),(2046,true,current_date,0,'CAIXA 4X6UN','CX ',6,1000,1000,'GR','GR','4X6U'),(2047,true,current_date,0,'DISPLAY 14X25G','DP ',14,350,360,'GR','GR','14X25G'),(2048,true,current_date,0,'CAIXETA 156X6G','CXT',156,936,936,'GR','GR','156X6G'),(2049,true,current_date,0,'CAIXA 12X269ML','CX ',12,3228,3230,'GR','GR','12X269ML'),(2050,true,current_date,0,'PACOTE 20X100UND','PCT',20,100,100,'GR','GR','20X100UND'),(2051,true,current_date,0,'UNIDADE 1X100UND','UND',1,0,0,'KG','KG','1X100UND'),(2052,true,current_date,0,'CAIXA 24X272G','CX ',24,6528,6530,'GR','GR','24X272G'),(2053,true,current_date,0,'UNIDADE 1X272G','UND',1,272,272,'GR','GR','1X272G'),(2054,true,current_date,0,'DISPLAY 24X19G','DP ',24,456,460,'GR','GR','24X19G'),(2055,true,current_date,0,'DUZIA 12X3UND','DZ ',12,0,0,'GR','GR','12X3'),(2056,true,current_date,0,'UNIDADE 1X19G','UND',1,19,20,'GR','GR','1X19G'),(2057,true,current_date,0,'CAIXA 10X150g','CX ',10,1500,1500,'GR','GR','10X150G'),(2058,true,current_date,0,'DISPLAY 15X38g','DP ',15,570,570,'GR','GR','15X38G'),(2059,true,current_date,0,'DISPLAY 15X30g','DP ',15,450,450,'GR','GR','15X30G'),(2060,true,current_date,0,'CAIXA 12X730g','CX ',12,8760,8760,'GR','GR','12X730G'),(2061,true,current_date,0,'UNIDADE 1X730g','UND',1,730,730,'GR','GR','1X730G'),(2062,true,current_date,0,'DISPLAY 18X27g','DP ',18,486,486,'GR','GR','18X27G'),(2063,true,current_date,0,'DISPLAY 24X20g','DP ',24,480,480,'GR','GR','24X20G'),(2064,true,current_date,0,'CAIXA 48X250ml','CX ',48,12000,12000,'GR','GR','48X250ML'),(2065,true,current_date,0,'DISPLAY 12X50g','DP ',12,600,600,'GR','GR','12X50G'),(2066,true,current_date,0,'FARDO 24X40und','FD ',24,0,0,'GR','GR','24X40UND'),(2067,true,current_date,0,'FARDO 24X20und','FD ',24,0,0,'GR','GR','24X20UND'),(2068,true,current_date,0,'CAIXA 18X600g','CX ',18,10800,10800,'GR','GR','18X600G'),(2069,true,current_date,0,'DISPLAY 14X20g','DP ',14,280,280,'GR','GR','14X20G'),(2070,true,current_date,0,'CAIXA 10X8UND','CX ',10,80,80,'GR','GR','10X8UNG'),(2071,true,current_date,0,'CAIXA 18X380g','CX ',18,6840,6840,'GR','GR','18X380G'),(2072,true,current_date,0,'CAIXA 24X95g','CX ',24,2280,2280,'GR','GR','24X95G'),(2073,true,current_date,0,'CAIXA 40X80g','CX ',40,3200,3200,'KG','GR','40X80G'),(2074,true,current_date,0,'UNIDADE 1X15ml','UND',1,15,15,'GR','GR','1X15ML'),(2075,true,current_date,0,'DISPLAY 14X22g','DP ',14,308,308,'GR','GR','14X22G'),(2076,true,current_date,0,'CAIXA 6X2,2KG','CX ',6,13200,13300,'GR','GR','6X2,2KG'),(2077,true,current_date,0,'UNIDADE 1X2,2kg','UND',1,2200,2200,'GR','GR','1X2,2KG'),(2078,true,current_date,0,'PACOTE 4X400ML','PCT',4,1600,1700,'GR','GR','4X400ML'),(2079,true,current_date,0,'CAIXA 16X100ml','CX ',16,1600,1600,'GR','GR','16X100ML'),(2080,true,current_date,0,'PLACA 4X100g','PL ',4,400,400,'GR','GR','4X100G'),(2081,true,current_date,0,'UNIDADE 1X1.005kg','UND',1,1005,1005,'GR','GR','1X1,005KG'),(2082,true,current_date,0,'CAIXA 92X18G','CX ',92,1656,1660,'GR','GR','92X18G'),(2083,true,current_date,0,'PACOTE 50X21,5g','PCT',50,1,1,'KG','KG','50X21,5G'),(2084,true,current_date,0,'UNIDADE 1X21,5g','UND',1,21500,21500,'GR','GR','1X21,5G'),(2085,true,current_date,0,'CAIXA 4X355ml','CX ',4,1420,1420,'GR','GR','4X355ML'),(2086,true,current_date,0,'CAIXA 6X355ML','CX ',6,2130,2130,'GR','GR','6X355ML'),(2087,true,current_date,0,'CAIXA 7X500G','CX ',7,3500,3600,'GR','GR','7X500G'),(2088,true,current_date,0,'CAIXA C/14,05kg','CX ',14050,14050,14050,'KG','KG','14,5KG'),(2089,true,current_date,0,'UNIDADE 1X40UN','UN ',1,100,120,'GR','GR','1X40UN'),(2090,true,current_date,0,'DISPLAY 14X40g','DP ',14,560,560,'GR','GR','14X40G'),(2091,true,current_date,0,'CAIXA 12X690G','CX ',12,8280,8300,'GR','GR','12X690G'),(2092,true,current_date,0,'UNIDADE 1X690G','UND',1,690,700,'GR','GR','1X690G'),(2093,true,current_date,0,'POTE 60X15g','PT ',60,900,900,'GR','GR','60X15G'),(2094,true,current_date,0,'CAIXA 30X330G','CX ',30,9900,9950,'GR','GR','30X330G'),(2095,true,current_date,0,'CAIXA 36X160g','CX ',36,5760,5770,'GR','GR','36X160G'),(2096,true,current_date,0,'CAIXA 42X124G','CX ',42,5208,5300,'GR','GR','42X124G'),(2097,true,current_date,0,'DISPLAY 40X5G','DP ',40,200,210,'GR','GR','40X5G'),(2098,true,current_date,0,'CAIXA 25X15M','CX ',25,5000,5100,'GR','GR','25X15M'),(2099,true,current_date,0,'CAIXA 25X30M','CX ',25,5000,5100,'GR','GR','25X30M'),(2100,true,current_date,0,'UNIDADE 1X15M','UND',1,150,180,'GR','GR','1X15M'),(2101,true,current_date,0,'UNIDADE 1X30M','UND',1,150,180,'GR','GR','1X30M'),(2102,true,current_date,0,'CAIXA 12X104g','CX ',12,1248,1248,'GR','GR','12X104G'),(2103,true,current_date,0,'UNIDADE 1X104g','UND',1,104,104,'GR','GR','1X104G'),(2104,true,current_date,0,'CAIXA 30X60UN','CX ',30,2000,2500,'GR','GR','30X60UN'),(2105,true,current_date,0,'UNIDADE 1X60UN','UND',1,200,250,'GR','GR','1X60UN'),(2106,true,current_date,0,'CAIXA 150X6g','CX ',150,900,900,'GR','GR','150X6G'),(2107,true,current_date,0,'CAIXA 36X48UN','CX ',36,20000,20500,'GR','GR','36X48UN'),(2108,true,current_date,0,'PACOTE C/4UND','PCT',4,0,0,'KG','KG','4X1'),(2109,true,current_date,0,'CAIXA 12X216g','CX ',12,216,216,'GR','GR','12X216G'),(2110,true,current_date,0,'UNIDADE 1X216g','UND',1,216,216,'GR','GR','1X216G'),(2111,true,current_date,0,'CAIXA 15X375g','CX ',15,5625,5625,'GR','GR','15X375G'),(2112,true,current_date,0,'UNIDADE 1X212g','UND',1,212,212,'GR','GR','1X212G'),(2113,true,current_date,0,'UNIDADE 1X25ML','UND',1,50,55,'GR','GR','1X25ML'),(2114,true,current_date,0,'UNIDADE 1X75ML','UND',1,100,110,'GR','GR','1X75ML'),(2115,true,current_date,0,'CAIXA 15X500G','CX ',15,7500,7550,'GR','GR','15X500G'),(2116,true,current_date,0,'CAIXA 72X20g','CX ',72,1440,1440,'GR','GR','72X20G'),(2117,true,current_date,0,'DUZIA 12X160ML','DZ ',12,0,0,'KG','KG','12X160ML'),(2118,true,current_date,0,'PACOTE 6X245g','PCT',245,1470,1470,'GR','GR','6X245G'),(2119,true,current_date,0,'PACOTE 3X230g','PCT',3,690,690,'GR','GR','3X230G'),(2120,true,current_date,0,'PACOTE 6X230g','PCT',6,1380,1380,'GR','GR','6X230G'),(2121,true,current_date,0,'PACOTE 3X640g','PCT',3,1920,1920,'GR','GR','3X640'),(2122,true,current_date,0,'UNIDADE 1X640g','UND',1,640,640,'GR','GR','1X640G'),(2123,true,current_date,0,'PACOTE 6X245g','PCT',6,1470,1470,'GR','GR','6X245G'),(2124,true,current_date,0,'CAIXA 24X355g','CX ',24,8520,8520,'GR','GR','24X355G'),(2125,true,current_date,0,'UNIDADE 1X355g','UND',1,355,355,'GR','GR','1X355G'),(2126,true,current_date,0,'FARDO 30X160g','FD ',30,4800,4800,'GR','GR','30X160G'),(2127,true,current_date,0,'CAIXA 6X190G','CX ',6,1140,1145,'GR','GR','6X190G'),(2128,true,current_date,0,'DISPLAY 12X30g','DP ',12,360,360,'GR','GR','12X30G'),(2129,true,current_date,0,'CAIXA 24X1.01kg','CX ',24,2424,2424,'GR','GR','24X1,01KG'),(2130,true,current_date,0,'UNIDADE 1X1,01kg','UND',1,1010,1010,'GR','GR','1X1,01KG'),(2131,true,current_date,0,'UNIDADE 1X336ML','UND',1,336,336,'GR','GR','1X336ML'),(2132,true,current_date,0,'PACOTE 6X68g','PCT',6,408,408,'GR','GR','6X68G'),(2133,true,current_date,0,'FARDO 12X16UN','FD ',12,2000,2500,'GR','GR','12X16UN'),(2134,true,current_date,0,'CAIXETA 1X355g','CXT',1,355,355,'GR','GR','1X355G'),(2135,true,current_date,0,'CAIXA 4X1,500kg','CX ',4,6,6,'KG','KG','4X1,500KG'),(2136,true,current_date,0,'CAIXA 30X200ml','CX ',30,6,6,'KG','KG','30X200ML'),(2137,true,current_date,0,'UNIDADE 1X1.500kg','UND',1,1500,1500,'GR','GR','1X1,500KG'),(2138,true,current_date,0,'PACOTE 5X1KG','PCT',5,5,5,'KG','KG','5X1KG'),(2139,true,current_date,0,'FARDO 1X10,1kg','FD ',1,10100,10100,'KG','KG','1X10,1KG'),(2140,true,current_date,0,'FARDO 1X15KG','FD ',1,15,15,'KG','KG','1X15KG'),(2141,true,current_date,0,'PACOTE 5X900g','PCT',5,4500,4500,'GR','GR','5X900G'),(2142,true,current_date,0,'PACOTE 6X290g','PCT',6,1740,1740,'GR','GR','6X290G'),(2143,true,current_date,0,'PACOTE 6X280g','PCT',6,1680,1680,'GR','GR','6X280G'),(2144,true,current_date,0,'CAIXA 10X330G','CX ',10,3300,3400,'GR','GR','10X330G'),(2145,true,current_date,0,'FARDO 100X45g','FD ',100,4500,4550,'GR','GR','100X45G'),(2146,true,current_date,0,'DISPLAY 12X85g','DP ',12,1020,1020,'GR','GR','12X85G'),(2147,true,current_date,0,'PACOTE 5X500g','PCT',5,2500,2500,'GR','GR','5X500G'),(2148,true,current_date,0,'CAIXA 24X210g','CX ',24,5040,5040,'GR','GR','24X210G'),(2149,true,current_date,0,'CAIXA 15X23g','CX ',15,345,345,'GR','GR','15X23G'),(2150,true,current_date,0,'CAIXA 15X35g','CX ',15,525,525,'GR','GR','15X35G'),(2151,true,current_date,0,'CAIXA 15X28g','CX ',15,420,420,'GR','GR','15X28G'),(2152,true,current_date,0,'CAIXA 15X33g','CX ',15,495,495,'GR','GR','15X33G'),(2153,true,current_date,0,'CAIXA 72X125g','CX ',72,9000,9000,'GR','GR','72X125G'),(2154,true,current_date,0,'CAIXA 4X2KG','CX ',4,8000,8100,'GR','GR','4X2KG'),(2155,true,current_date,0,'DISPLAY 20X52,7g','DP ',20,1054,1054,'GR','GR','20X52,7G'),(2156,true,current_date,0,'DISPLAY 18X45g','DP ',18,810,810,'GR','GR','18X45G'),(2157,true,current_date,0,'DISPLAY 18X49g','DP ',18,882,882,'GR','GR','18X49G'),(2158,true,current_date,0,'DISPLAY 24X52,2g','DP ',24,1253,1253,'GR','GR','24X52,2G'),(2160,true,current_date,0,'UNIDADE 1X52,7g','UND',1,53,53,'GR','GR','1X52,7G'),(2159,true,current_date,0,'UNIDADE 1X52,2g','UND',1,52,52,'GR','GR','1X52,2G'),(2161,true,current_date,0,'CAIXA 36X65G','CX ',36,2340,2400,'GR','GR','36X65G'),(2162,true,current_date,0,'PACOTE 3X300g','PCT',3,900,900,'GR','GR','3X300G'),(2163,true,current_date,0,'PACOTE 3X500g','PCT',3,1500,1500,'GR','GR','3X500G'),(2164,true,current_date,0,'PACOTE 2X200g','PCT',2,400,400,'GR','GR','2X200G'),(2165,true,current_date,0,'UNIDADE 1X1350G','UND',1,1350,1360,'GR','GR','1X1350G'),(2166,true,current_date,0,'PACOTE 5X12UND','PCT',12,950,1000,'GR','GR','5X12UND'),(2167,true,current_date,0,'DISPLAY 66X10G','DP ',66,660,670,'GR','GR','66X10G'),(2168,true,current_date,0,'PACOTE 3X35g','PCT',3,105,105,'GR','GR','3X35G'),(2169,true,current_date,0,'CAIXA 8X425G','CX ',8,3400,3450,'GR','GR','8X425G'),(2170,true,current_date,0,'UNIDADE 1X2g','UND',1,2,2,'GR','GR','1X2G'),(2171,true,current_date,0,'CAIXA 28X320g','CX ',28,8960,8960,'GR','GR','28X320G'),(2172,true,current_date,0,'PACOTE 3X50ml','PCT',3,0,0,'GR','GR','3X50ML'),(2173,true,current_date,0,'CAIXA 8X220ML','CX ',8,1720,1750,'GR','GR','8X220ML'),(2174,true,current_date,0,'UNIDADE 4X80G','UN ',4,320,330,'GR','GR','4X80G'),(2175,true,current_date,0,'CAIXA 22X195g','CX ',22,4290,4290,'GR','GR','22X195G'),(2177,true,current_date,0,'UNIDADE 1X195g','UND',1,195,195,'GR','GR','1X195G'),(2178,true,current_date,0,'CAIXA 48X40G','CX ',48,1920,1930,'GR','GR','48X40G'),(2179,true,current_date,0,'CAIXA 48X55G','CX ',48,2640,2650,'GR','GR','48X55G'),(2180,true,current_date,0,'CAIXA 60X36G','CX ',60,368,370,'GR','GR','60X36G'),(2181,true,current_date,0,'FARDO 50X32G','FD ',50,1600,1650,'GR','GR','50X32G'),(2182,true,current_date,0,'CAIXA 12X235ML','CX ',12,2820,2830,'GR','GR','12X235ML'),(2183,true,current_date,0,'UNIDADE 1X235ML','UND',1,235,240,'GR','GR','1X235ML'),(2184,true,current_date,0,'CAIXA 108X84g','CX ',108,9072,9072,'GR','GR','108X84G'),(2185,true,current_date,0,'CAIXA 120X1','CX ',120,120,130,'GR','GR','120X1'),(2186,true,current_date,0,'CAIXA 42X80G','CX ',42,3360,3370,'GR','GR','42X80G'),(2187,true,current_date,0,'CAIXA 27X180ml','CX ',27,4860,4860,'GR','GR','27X180ML'),(2188,true,current_date,0,'DISPLAY 18X52g','DP ',18,936,936,'GR','GR','18X52G'),(2189,true,current_date,0,'UNIDADE 1X52g','UND',1,52,52,'GR','GR','1X52G'),(2190,true,current_date,0,'FARDO 12X750g','FD ',12,9000,9000,'GR','GR','12X750G'),(2191,true,current_date,0,'CAIXA 18X1KG','CX ',18,1800,1850,'GR','GR','18X1KG'),(2192,true,current_date,0,'PACOTE 8X90g','PCT',8,720,720,'GR','GR','8X90G'),(2193,true,current_date,0,'DISPLAY 8X40g','DP ',8,320,320,'GR','GR','8X40G'),(2194,true,current_date,0,'CAIXA 21X360g','CX ',21,7560,7560,'GR','GR','21X360G'),(2195,true,current_date,0,'DISPLAY 36X11g','DP ',36,396,396,'GR','GR','36X11G'),(2196,true,current_date,0,'UNIDADE 1X11g','UND',1,11,11,'GR','GR','1X11G'),(2197,true,current_date,0,'PACOTE 2X500g','PCT',2,1000,1000,'GR','GR','2X500G'),(2198,true,current_date,0,'CAIXA 10X390G','CX ',10,3900,4000,'GR','GR','10X390G'),(2199,true,current_date,0,'FARDO 60X4UND','FD ',60,140,140,'GR','GR','60X4UND'),(2200,true,current_date,0,'UNIDADE 1X146G','UND',1,146,146,'GR','GR','1X146G'),(2201,true,current_date,0,'CAIXA 50X32g','CX ',50,16,16,'GR','GR','50X32G'),(2202,true,current_date,0,'CAIXA 4X3,5KG','CX ',4,14000,14000,'GR','GR','4X3,5KG'),(2203,true,current_date,0,'CAIXA 12X820G','CX ',12,9840,9840,'GR','GR','12X820G'),(2204,true,current_date,0,'UNIDADE 1X3,5KG','UND',1,3500,3500,'GR','GR','1X3,5KG'),(2205,true,current_date,0,'UNIDADE 1X820G','UND',1,820,820,'GR','GR','1X820G'),(2206,true,current_date,0,'FARDO 64X30M','FD ',64,640,640,'GR','GR','64X30M'),(2207,true,current_date,0,'DISPLAY 10X34g','DP ',10,340,340,'GR','GR','10X34G'),(2208,true,current_date,0,'SACO 1X25KG','SC ',1,2500,2500,'GR','GR','1X25KG'),(2209,true,current_date,0,'CAIXA 8X450g','CX ',8,3600,3600,'GR','GR','8X450G'),(2210,true,current_date,0,'CAIXA 18X800g','CX ',18,14400,14400,'GR','GR','18X800G'),(2211,true,current_date,0,'CAIXA 40X115g','CX ',40,4600,4600,'GR','GR','40X115G'),(2212,true,current_date,0,'CAIXA 9X450ml','CX ',9,4050,4050,'GR','GR','9X450ML'),(2213,true,current_date,0,'CAIXA 8X600g','CX ',8,4800,4800,'GR','GR','8X600G'),(2214,true,current_date,0,'CAIXA 48X30g','CX ',48,1440,1440,'GR','GR','48X30G'),(2215,true,current_date,0,'CAIXA 5X350ml','CX ',5,1750,1750,'GR','GR','5X350ML'),(2216,true,current_date,0,'DISPLAY 20X18,8g','DP ',20,376,376,'GR','GR','20X18,8G'),(2217,true,current_date,0,'DISPLAY 20X55g','DP ',20,1100,1100,'GR','GR','20X55G'),(2218,true,current_date,0,'UNIDADE 1X18,8g','UND',1,19,19,'GR','GR','1X18,8G'),(2219,true,current_date,0,'DISPLAY 63X504g','DP ',63,504,504,'GR','GR','63X504G'),(2220,true,current_date,0,'CAIXA 20X312g','CX ',20,6240,6240,'GR','GR','20X312G'),(2221,true,current_date,0,'UNIDADE 1X312g','UND',1,312,312,'GR','GR','1X312G'),(2222,true,current_date,0,'CAIXA 192X7g','CX ',192,1344,1344,'GR','GR','192X7G'),(2223,true,current_date,0,'PACOTE 1X800g','PCT',1,800,800,'GR','GR','1X800G'),(2224,true,current_date,0,'CAIXA 24X144G','CX ',24,3456,3456,'GR','GR','24X144G'),(2225,true,current_date,0,'CAIXA 32X126G','CX ',32,4032,4032,'GR','GR','32X126G'),(2226,true,current_date,0,'UNIDADE 1X144G','UND',1,144,144,'GR','GR','1X144G'),(2227,true,current_date,0,'CAIXETA 30X2,5G','CXT',30,75,75,'GR','GR','30X2,5G'),(2228,true,current_date,0,'DISPLAY 40X36g','DP ',40,1440,1440,'GR','GR','40X36G'),(2229,true,current_date,0,'DISPLAY 40X23g','DP ',40,920,920,'GR','GR','40X23G'),(2230,true,current_date,0,'CAIXA 4X3,3L','CX ',4,13200,13200,'GR','GR','4X3,3L'),(2231,true,current_date,0,'UNIDADE 1X3,3L','UND',1,3300,3300,'GR','GR','1X3,3L'),(2232,true,current_date,0,'PACOTE 10X50UND','PCT',10,0,0,'KG','KG','10X50UND'),(2233,true,current_date,0,'CAIXA 6X1,100g','CX ',6,1100,1100,'GR','GR','6X1,100G'),(2234,true,current_date,0,'CAIXA 60X32g','CX ',60,1920,1920,'GR','GR','60X32G'),(2235,true,current_date,0,'UNIDADE 1X29g','UND',1,29,29,'GR','GR','1X29G'),(2236,true,current_date,0,'FARDO 12X25g','FD ',12,300,300,'GR','GR','12X25G'),(2237,true,current_date,0,'CAIXA 4X2kg','CX ',8,8,8,'KG','KG','4X2KG'),(2238,true,current_date,0,'CAIXA 42X60G','CX ',42,2520,2520,'GR','GR','42X60G'),(2239,true,current_date,0,'UNIDADE 1X395ml','UND',1,395,395,'GR','GR','1X395ML'),(2240,true,current_date,0,'CAIXA 24X120M','CX ',24,2880,2880,'GR','GR','24X120M'),(2241,true,current_date,0,'CAIXETA 1X428,8G','CXT',16,4288,4288,'GR','GR','1X428,8G'),(2242,true,current_date,0,'UNIDADE 1X26,8G','UN ',1,268,268,'GR','GR','1X26,8G'),(2243,true,current_date,0,'CAIXETA 1X433,6G','CXT',16,4336,4336,'GR','GR','1X433,6G'),(2244,true,current_date,0,'UNIDADE 1X27,1G','UN ',1,271,271,'GR','GR','1X27,1G'),(2245,true,current_date,0,'UNIDADE 3X32G','UND',3,96,96,'GR','GR','3X32G');
