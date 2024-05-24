let hello = new Promise( (resolve, reject)=> {
    setTimeout(() => {
        resolve("Olá mundo!")
    }, 2000);
})

hello.then(mensagem=>console.log(mensagem))

let helloError = new Promise( (resolve, reject)=> {
    setTimeout(() => {
        reject(new Error('Deu ruim...'))
    }, 2000);
})

helloError
    .then( resultado => console.log(resultado))
    .catch(erro => console.log(erro))