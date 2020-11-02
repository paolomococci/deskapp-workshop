yieldUnescaped '<!DOCTYPE html>'
html(lang:'en') {
    head {
        meta('http-equiv':'"Content-Type" content="text/html; charset=utf-8"')
        title('address')
        link(rel: "stylesheet", href: "/webjars/bootstrap/4.5.3/css/bootstrap.min.css")
    }
    body {
        nav(class: 'navbar navbar-expand-md navbar-dark bg-dark'){
            a(href: "#", class: "navbar-brand", "address")
            input(class: 'form-control form-control-dark w-100', type: 'text', placeholder: 'search')
            ui(class: 'navbar-nav mr-auto', style: 'margin-left: 10px;'){
                li(class: 'nav-item active') {
                    a(href: "/index", class: "navbar-brand", "index")
                }
                li(class: 'nav-item') {
                    a(href: "/customer", class: "navbar-brand", "customer")
                }
            }
        }
        hr()
        div(class: 'container', style: 'margin-top: 100px;'){
            form(action: '/address-create', method: 'post'){
                div(class: 'row d-flex align-content-center flex-wrap'){
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'country', name: 'country')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'city', name: 'city')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'street', name: 'street')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'civic', name: 'civic')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'code', name: 'code')
                    }
                    div(class: 'col'){
                        input(type: 'submit', class: 'btn btn-primary', value: 'Add')
                    }
                }
            }
            table(class: 'table', style: 'margin-top: 50px;'){
                thead(){
                    tr(){
                        th('country')
                        th('city')
                        th('street')
                        th('civic')
                        th('code')
                        th('')
                    }
                }
                tbody(){
                    addresses.each { address ->
                        tr(){
                            td("$address.country")
                            td("$address.city")
                            td("$address.street")
                            td("$address.civic")
                            td("$address.code")
                            td(){
                                a(href: "/address-update/$address.id", class: "btn btn-info btn-sm", style: 'margin-right: 5px;', "update")
                                a(href: "/address-delete/$address.id", class: "btn btn-danger btn-sm", "delete")
                            }
                        }
                    }
                }
            }
        }
    }
}
