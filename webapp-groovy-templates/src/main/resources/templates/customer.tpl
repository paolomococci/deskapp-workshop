yieldUnescaped '<!DOCTYPE html>'
html(lang:'en') {
    head {
        meta('http-equiv':'"Content-Type" content="text/html; charset=utf-8"')
        title('customer')
        link(rel: "stylesheet", href: "/webjars/bootstrap/4.5.3/css/bootstrap.min.css")
    }
    body {
        nav(class: 'navbar navbar-expand-md navbar-dark bg-dark'){
            a(href: "#", class: "navbar-brand", "customer")
            input(class: 'form-control form-control-dark w-100', type: 'text', placeholder: 'search')
            ui(class: 'navbar-nav mr-auto', style: 'margin-left: 10px;'){
                li(class: 'nav-item active') {
                    a(href: "/index", class: "navbar-brand", "index")
                }
                li(class: 'nav-item') {
                    a(href: "/address", class: "navbar-brand", "address")
                }
            }
        }
        hr()
        div(class: 'container', style: 'margin-top: 100px;'){
            form(action: '/customer-create', method: 'post'){
                div(class: 'row'){
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'name', name: 'name')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'surname', name: 'surname')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'email', name: 'email')
                    }
                    div(class: 'col'){
                        input(type: 'submit', class: 'btn btn-primary', value: 'Add')
                    }
                }
            }
            table(class: 'table', style: 'margin-top: 50px;'){
                thead(){
                    tr(){
                        th('name')
                        th('surname')
                        th('email')
                        th('action')
                    }
                }
                tbody(){
                    customers.each { customer ->
                        tr(){
                            td($customer.name)
                            td($customer.surname)
                            td($customer.email)
                            td(){
                                a(href: "/customer-update/$customer.id", class: "btn btn-info btn-sm", style: 'margin-right: 5px;', "update")
                                a(href: "/customer-delete/$customer.id", class: "btn btn-danger btn-sm", "delete")
                            }
                        }
                    }
                }
            }
        }
    }
}
