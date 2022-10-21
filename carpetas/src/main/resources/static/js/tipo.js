const url = "http://localhost:8080/tipo/"
const url1 = "http://localhost:8080/tipo/list"
//const url = "http://150.136.211.43:8080/seguimiento/tipo/"
//const url1 = "http://150.136.211.43:8080/seguimiento/tipo/list"
const contenedor = document.querySelector('tbody')
let resultados = ''

const modalTipos = new bootstrap.Modal(document.getElementById('modalTipo'))
const formTipos = document.querySelector('form')
const tipoCliente = document.getElementById('tipdoc')
const idTipo = document.getElementById('id')
const estadoTipo = document.getElementById('estado')
const observacionTipo = document.getElementById('observacion')
let opcion = ''

btnCrear.addEventListener('click', () => {
    idTipo.value = ''
    estadoTipo.value = ''
    observacionTipo.value = ''
    idTipo.disabled = false
    modalTipos.show()
    opcion = 'crear'
})

btnCerrar.addEventListener('click', () => {
    
    modalTipos.hide()
   
})

btnclose.addEventListener('click', () => {
    
    modalTipos.hide()
   
})
//funcion para mostrar resultados

const mostrar = (Tipos) => {
    Tipos.forEach(Tipo => {
        resultados += `<tr>
                        <td>${Tipo.codigo_tip}</td>
                        <td>${Tipo.estado_tip}</td>
                        <td>${Tipo.observacion_tip}</td>
                        <td class="text-center" width="20%"><a class="btnEditar btn btn-primary">Editar</a><a class="btnBorrar btn btn-danger">Borrar</a></td>
                    </tr>`
    })

    contenedor.innerHTML = resultados
}

//procedimiento mostrar registros
fetch(url1)
    .then(response => response.json())
    .then(data => mostrar(data))
    .catch(error => console.log(error))

const on = (element, event, selector, handler) => {
    element.addEventListener(event, e => {
        if (e.target.closest(selector))
            handler(e)
    })
}

on(document, 'click', '.btnBorrar', e => {
    const fila = e.target.parentNode.parentNode
    const id = fila.firstElementChild.innerHTML
    console.log(id)

    alertify.confirm("Desea eliminar el Tipo "+id,
        function () {
            fetch(url + id, {
                method: 'DELETE'
            })
                .then(() => location.reload())
        },
        function () {
            alertify.error('Cancelado')
        });
})

let idForm = 0
on(document, 'click', '.btnEditar', e => {

    const fila = e.target.parentNode.parentNode
    
    idForm = fila.children[0].innerHTML
    const estado = fila.children[1].innerHTML
    const observacion = fila.children[2].innerHTML
    idTipo.value = idForm
    idTipo.disabled = true
    estadoTipo.value = estado
    observacionTipo.value = observacion

    opcion = 'editar'
    modalTipos.show()
})

formTipos.addEventListener('submit', (e) => {
    e.preventDefault()

        if (opcion == 'crear') {
            fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    codigo_tip: idTipo.value,
                    estado_tip: estadoTipo.value,
                    observacion_tip: observacionTipo.value
                })
            })
                .then(response => response.json())
                .then(data => {
                    const nuevoTipo = []
                    nuevoTipo.push(data)
                    mostrar(nuevoTipo)
                })
        }
        
        
        
        if (opcion == 'editar') {

            fetch(url, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    codigo_tip: idForm,
                    estado_tip: estadoTipo.value,
                    observacion_tip: observacionTipo.value
                })
            })
                .then(response => location.reload())

        }
        modalTipos.hide()
    
})
