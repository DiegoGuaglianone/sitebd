/* Serial = inteiro e autoincrement */
CREATE TABLE IF NOT EXISTS livro (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    ano_lancamento INT NOT NULL,
    preco DECIMAL(10, 2) NOT NULL
);
        -- comando magico: ( drop schema public; )