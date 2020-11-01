yieldUnescaped '<!DOCTYPE html>'
html(lang:'en') {
    head {
        meta('http-equiv':'"Content-Type" content="text/html; charset=utf-8"')
        title('customer update')
        link(rel: "stylesheet", href: "/webjars/bootstrap/4.5.3/css/bootstrap.min.css")
    }
    body {
        nav(class: 'navbar navbar-expand-md navbar-dark bg-dark'){
            a(href: "#", class: "navbar-brand", "customer-update")
        }
        hr()
        div(class: 'container', style: 'margin-top: 100px;'){
            form(action: '/customer-update', method: 'post'){
                div(class: 'row d-flex align-content-center flex-wrap'){
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'name', value: "$updated.name", name: 'name')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'surname', value: "$updated.surname", name: 'surname')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'email', value: "$updated.email", name: 'email')
                    }
                    input(type: 'hidden',  value: "$updated.id", name: 'id')
                    div(class: 'col'){
                        input(type: 'submit', class: 'btn btn-primary', value: 'update')
                    }
                }
            }
        }
    }
}
