from aws_lambda_powertools import Logger
from aws_lambda_powertools.utilities.parameters import get_secret


logger = Logger(service="LambdaGetEndereco", level="INFO")

db_credentials = get_secret("teupet-credentials")


def get_db_host():
    return db_credentials["host"]


def get_db_user():
    return db_credentials["username"]


def get_db_password():
    return db_credentials["password"]


def get_db_database():
    return db_credentials["dbname"]
