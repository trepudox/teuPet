from aws_lambda_powertools import Logger


logger = Logger(service="LambdaGetEndereco", level="INFO")


def get_db_host():
    return "localhost"


def get_db_user():
    return "root"


def get_db_password():
    return "password"


def get_db_database():
    return "teupet"
