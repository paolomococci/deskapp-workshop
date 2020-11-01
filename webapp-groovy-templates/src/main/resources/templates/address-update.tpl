yieldUnescaped '<!DOCTYPE html>'
html(lang:'en') {
    head {
        meta('http-equiv':'"Content-Type" content="text/html; charset=utf-8"')
        title('address update')
        link(rel: "stylesheet", href: "/webjars/bootstrap/4.5.3/css/bootstrap.min.css")
    }
    body {
        nav(class: 'navbar navbar-expand-md navbar-dark bg-dark'){
            a(href: "#", class: "navbar-brand", "address-update")
        }
        hr()
        div(class: 'container', style: 'margin-top: 100px;'){
            form(action: '/address-update', method: 'post'){
                div(class: 'row d-flex align-content-center flex-wrap'){
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'country', value: "$updated.country", name: 'country')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'city', value: "$updated.city", name: 'city')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'street', value: "$updated.street", name: 'street')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'civic', value: "$updated.civic", name: 'civic')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'code', value: "$updated.code", name: 'code')
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
