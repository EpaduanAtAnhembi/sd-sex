const codigo = document.getElementById("codigo")
const nome = document.getElementById("nome")
const valor = document.getElementById("valor")
const btnBuscar = document.getElementById("btnBuscar")
const btnSalvar = document.getElementById("btnSalvar")
const btnAtualizar = document.getElementById("btnAtualizar")

async function getById() {
    let id = codigo.value
    const resposta = await fetch('http://localhost:8080/produto/' + id)
    if(resposta.status == 200) {
        const dados = await resposta.json()
        codigo.value = dados['codigo']
        nome.value = dados['nome']
        valor.value = dados['valor']
    } else {
        nome.value = 'Não encontrado'
    }
}

btnBuscar.addEventListener('click', getById)

async function save() {
    const resposta = await fetch('http://localhost:8080/produto',{
        method:'POST',
        headers:{
            'Content-Type':'application/json'
        },
        body: JSON.stringify({
            "nome": nome.value,
            "valor": valor.value
        })
    })
    if(resposta.status == 201) {
        const dados = await resposta.json()
        codigo.value = dados['codigo']
        nome.value = dados['nome']
        valor.value = dados['valor']
    } else {
        nome.value = 'Erro'
    }
}

btnSalvar.addEventListener('click', save)

async function atualizar() {
    const resposta = await fetch('http://localhost:8080/produto',{
        method:'PUT',
        headers:{
            'Content-Type':'application/json'
        },
        body: JSON.stringify({
            "codigo": codigo.value,
            "nome": nome.value,
            "valor": valor.value
        })
    })
    if(resposta.status == 200) {
        const dados = await resposta.json()
        codigo.value = ''
        nome.value = ''
        valor.value = ''
        alert('Sucesso')
    } else {
        nome.value = 'Erro'
    }
}

btnAtualizar.addEventListener('click', atualizar)