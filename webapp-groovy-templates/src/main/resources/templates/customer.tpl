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
            ui(class: 'navbar-nav mr-auto'){
                li(class: 'nav-item active') {
                    a(href: "/index", class: "navbar-brand", "index")
                }
                li(class: 'nav-item') {
                    a(href: "/address", class: "navbar-brand", "address")
                }
            }
        }
        hr()
        div(class: 'container'){
            form(action: '', method: 'post'){
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
            table(class: 'table', style: 'margin-top: 20px;'){
                thead(){
                    tr(){
                        th('name')
                        th('surname')
                        th('email')
                        th('action')
                    }
                }
                tbody(){
                    //customer.each { customer ->
                        tr(){
                            td("some")
                            td("some")
                            td("someone")
                            td("crud"){
                                a(href: "/customer-update", class: "btn btn-info btn-sm", style: 'margin-right: 5px;', "update")
                                //a(href: "/delete/$customer.uri", class: "btn btn-danger btn-sm", "delete")
                            }
                        }
                    //}
                }
            }
        }
    }
}
