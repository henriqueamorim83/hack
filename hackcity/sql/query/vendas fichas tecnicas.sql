 

select receita.id, receita.descricao,  (select sum(e.quantidade) from tb_pedido_produto as e inner join tb_item_pedido as i on i.id=e.fk_id_item_pedido
inner join tb_receita as r on i.fk_id_receita=r.id inner join tb_pedido as pedido on pedido.id=e.fk_id_pedido
inner join tb_cliente as cliente on cliente.id=pedido.fk_id_cliente
where e.situacao_pedido>=2 and pedido.fk_id_cliente=5002 and r.id = receita.id ) as QUANTIDADE,
to_char
((select sum(e.valor) from tb_pedido_produto as e inner join tb_item_pedido as i on i.id=e.fk_id_item_pedido
inner join tb_receita as r on i.fk_id_receita=r.id inner join tb_pedido as pedido on pedido.id=e.fk_id_pedido
inner join tb_cliente as cliente on cliente.id=pedido.fk_id_cliente
where e.situacao_pedido>=2 and pedido.fk_id_cliente=5002 and r.id = receita.id ), 'L9G999G990D99') as SOMA,
to_char(receita.valor_venda, 'L9G999G990D99') as VENDA
from tb_receita as receita    

 --to_char(1250.75, 'L9G999G990D99')