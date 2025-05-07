from src.db_service import DatabaseService


def process(body, db_service: DatabaseService):
    if "pessoaId" not in body:
        raise ValueError("O parametro 'pessoaId' precisa ser informado")
    elif "enderecoId" not in body:
        return db_service.get_enderecos_by_pessoa_id(body["pessoaId"])
    else:
        return db_service.get_endereco_by_pessoa_id_and_endereco_id(
            body["pessoaId"], body["enderecoId"]
        )
