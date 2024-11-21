from src.config import logger, get_db_database, get_db_host, get_db_password, get_db_user
from src.db_service import DatabaseService
from src.lambda_processor import process


db_service: DatabaseService = DatabaseService(
    host=get_db_host(),
    user=get_db_user(),
    password=get_db_password(),
    database=get_db_database()
)


def lambda_handler(event, context):
    logger.info("Evento recebido: %s", event)

    try:
        resposta_processor = process(event, db_service)

        logger.info("Processamento finalizado com sucesso")

        return resposta_processor
    except Exception as e:
        logger.exception("Erro ao processar evento: %s", e)

        return {
            "body": "Erro ao processar evento"
        }
