# bank-account

## Observações.

- Foi realizado a validação do campo cpfoucnpj da classe Customer, conforme o id do customerType(Pessoa fisica ou Juridica).
- A documentacao do projeto foi realizado com o Swagger, foi disponibilizado os endpoints conforme o documento, listar pessoas
e listar as contas e seus respectivos limites/cartoes.

- Ao gerar o projeto no profile 'test, automaticamente o banco H2 é populado com alguns clientes.
- Foram realizados testes na camada de servico.
- É possivel registrar novos clientes a partir do enpoint '/bank/v1/customer/', fornecendo os seguintes atributos "name",
	"cpfOuCnpj","customerType".


