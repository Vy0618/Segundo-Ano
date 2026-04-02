 http://localhost:8080/


CREATE DATABASE petshop;
CREATE TABLE categoria (
    id_categoria INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    ativo BOOLEAN DEFAULT TRUE
);

CREATE TABLE produto(
  id_produto int primary key auto_increment, 
  nome varchar(100) not null,
  descricao text,
  preco double not null,
  preco_desconto not null,
  imagem long text,
  qntd_estoque int,
  ativo boolean default true,
  id_categoria int,
  foreign key (id_categoria) referencias categoria(id_categoria)
)

{
  "nome":"",
  "descricao":"",
  "preco":"",
  "preco_desconto":"",
  "qntd_estoque":"",
  "id_categoria":""
}

{
  "nome": "Cachorro",
  "descricao": "Canis lupus familiaris"
}


[ INSTALAÇÃO ]

No PowerShell:
npm install -D tailwindcss@3
npx tailwindcss init

Instala o Tailwindcss e cria o config file

No tailwind.config.js:
content: ["./*.html"]
Ele vai procurar por arquivos html por toda a pasta aonde o código está armazenado.

No root da pasta:
Criar uma pasta "src"

npx tailwindcss -i ./srcTailwind/input.css -o ./srcTailwind/output.css --watch
Gera o arquivo "output.css"

No input.css:
@tailwind base;
@tailwind components;
@tailwind utilities;

Depois é só linkar o output.css ( <link href="./srcTailwind/output.css" rel="stylesheet">)no HTML e instalar a extensão Tailwind CSS IntelliSense no VS Code.

