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
            ui(class: 'navbar-nav mr-auto'){
                li(class: 'nav-item active') {
                    a(href: "/index", class: "navbar-brand", "index")
                }
                li(class: 'nav-item') {
                    a(href: "/customer", class: "navbar-brand", "customer")
                }
            }
        }
        hr()
        div(class: 'container'){
            form(action: '', method: 'post'){
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
            table(class: 'table', style: 'margin-top: 20px;'){
                thead(){
                    tr(){
                        th('country')
                        th('city')
                        th('street')
                        th('civic')
                        th('code')
                        th('actions')
                    }
                }
                tbody(){
                    //address.each { address ->
                        tr(){
                            td("some")
                            td("some")
                            td("some")
                            td("some")
                            td("some")
                            td("crud"){
                                a(href: "/address-update", class: "btn btn-info btn-sm", style: 'margin-right: 5px;', "update")
                                //a(href: "/delete/$address.uri", class: "btn btn-danger btn-sm", "delete")
                            }
                        }
                    //}
                }
            }
        }
    }
}
