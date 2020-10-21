# banco-digital

Primeiramento deve ser configurado o arquivo application.properties

---------------


## Rota de cadastro de cliente
METHOD=POST
```
http://localhost:8080/cliente

Body

{
	"nome": "Nome aqui",
	"sobrenome": "Sobrenome",
	"email": "teste@gmail.com",
	"dataNascimento": "1990-01-01",
	"cpf": "xxx.xxx.xx-xx"
}
```

---------------



## Rota de cadstro de endereco
id - identificador do cliente

METHOD=POST
```
http://localhost:8080/cliente/{id}/endereco

{
	"cep": "xxxxx-xxx",
	"rua": "Nome da rua",
	"complemento": "complemento aqui",
	"cidade": "Cidade aqui",
	"estado": "Estado aqui"
}
```
---------------

## Rota de cadastro de anexo
METHOD=POST

id - identificador do cliente

http://localhost:8080/cliente/{id}/anexo

form-data
campo arquivo

---------------



## Rota de criacao do cliente
METHOD=POST

id - identificador do cliente

http://localhost:8080/cliente/{id}/finalizar
```
{
	"aceita": true
}
```
---------------


## Rota do primeiro acesso do cliente
METHOD=POST

http://localhost:8080/conta/acessar
```
{
	"email": "teste@gmail.com",
	"cpf": "xxx.xxx.xxx-xx"
}
```
---------------


## Rota de gerar nova senha do cliente
METHOD=POST

http://localhost:8080/conta/gerar-senha
```
{
	"token": "token",
	"senha": "12345678",
	"confirmarSenha": "12345678"
}
```

---------------

## Rota de deposito

METHOD=POST

OBS: Incompleto
http://localhost:8080/conta/deposito
```
[
	{
		"valor_transferencia": "50",
		"data_realizacao": "20/10/2020",
		"documento_identificador": "12312",
		"banco_origem": "4324",
		"conta_origem": "2323",
		"agencia_origem": "322",
		"codigo_unico": "1",
		"agencia_destino": "4261",
		"conta_destino": "73307330"
	}
]
```
