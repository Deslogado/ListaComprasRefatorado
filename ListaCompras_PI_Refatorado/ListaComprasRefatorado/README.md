# ListaComprasRefatorado

Status: Em desenvolvimento

## Objetivo
Organizar as regras principais do sistema ListaCompras para facilitar manutenção e reutilização em uma futura interface web.

## Tecnologias
- Java 17
- Maven
- NetBeans
- Git e GitHub

## Funcionalidades implementadas no núcleo refatorado
- Cadastro simples de usuário com validação básica.
- Criação de listas de compras.
- Cadastro de itens e associação a listas.
- Marcação de item como comprado.
- Repositórios em memória para executar os testes sem configurar banco de dados.

## Organização
- `modelo`: entidades do sistema.
- `repositorio`: contratos para armazenamento.
- `repositorio.memoria`: implementação em memória usada nos testes.
- `servico`: regras de negócio e validações.
- `ListaCompras`: executa testes simples no método `main()`.

## Como executar no NetBeans
1. Abra a pasta `ListaComprasRefatorado` como projeto Maven.
2. Use JDK 17 ou superior.
3. Execute a classe `br.com.listacompras.ListaCompras`.
4. Confira no console a mensagem `TODOS OS TESTES PASSARAM`.

Os repositórios em memória são usados para demonstrar as regras de negócio sem depender do MySQL. Eles não substituem a persistência do sistema desktop original.
