select e.id, p.descricao, c.descricao from Estoque e
left join e.produto as p
left join e.produtoComposto as c
where e.empresa=1
and e.localEstoque.id=1
and upper(p.descricao) like '%DELINE%'
or upper(c.descricao) like '%DELINE%'


select l.id  from Estoque l left join l.produto as p left join l.produtoComposto as c
where l.ativo=true and l.empresa=1 and l.localEstoque.id=1
and ( (upper(p.descricao) like '%DELINE%' and p.produtoComposto is null)  or upper(c.descricao) like '%DELINE%')