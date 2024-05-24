// fetch('https://jsonplaceholder.typicode.com/posts/1')
// .then(resposta => resposta.json())
// .then(dados => console.log(dados))
// .catch(erro => console.log(erro))

async function buscarDados() {
    const result = await fetch('https://jsonplaceholder.typicode.com/posts/1')
    const dados = await result.json()
    // console.log(dados);
    return dados
}

async function exibir(params) {
    let meusdados = await buscarDados()
    console.log(meusdados);
}

exibir()