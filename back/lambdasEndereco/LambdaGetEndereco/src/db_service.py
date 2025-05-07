from src.config import logger

import pymysql


class DatabaseService:
    def __init__(self, host, user, password, database):
        logger.info("Iniciando conexao com o banco de dados")

        self.connection = pymysql.connect(
                host=host,
                user=user,
                password=password,
                database=database
            )

    def get_enderecos_by_pessoa_id(self, pessoa_id):
        logger.info("Iniciando get_enderecos_by_pessoa_id. pessoa_id: %s", pessoa_id)

        with self.connection.cursor() as cursor:
            cursor.execute(
                'SELECT * FROM endereco_pessoa WHERE pessoa_id = %s;',
                (pessoa_id,)
            )

            return cursor.fetchall()

    def get_endereco_by_pessoa_id_and_endereco_id(self, pessoa_id, endereco_id):
        logger.info("Iniciando get_endereco_by_pessoa_id_and_endereco_id. pessoa_id: %s, endereco_id: %s", pessoa_id, endereco_id)

        with self.connection.cursor() as cursor:
            cursor.execute(
                'SELECT * FROM endereco_pessoa WHERE pessoa_id = %s AND endereco_id = %s;',
                (pessoa_id, endereco_id)
            )

            return cursor.fetchall()
