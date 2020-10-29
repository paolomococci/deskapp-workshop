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
        div(class: 'container', style: 'margin-top: 30px;'){
            form(action: '', method: 'post'){
                div(class: 'row d-flex align-content-center flex-wrap'){
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'country', value: "", name: 'country')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'city', value: "", name: 'city')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'street', value: "", name: 'street')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'civic', value: "", name: 'civic')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'code', value: "", name: 'code')
                    }
                    input(type: 'hidden',  value: "", name: 'uri')
                    div(class: 'col'){
                        input(type: 'submit', class: 'btn btn-primary', value: 'update')
                    }
                }
            }
        }
    }
}
