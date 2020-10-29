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
                        input(type: 'text', class: 'form-control', placeholder: 'name', value: "", name: 'name')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'surname', value: "", name: 'surname')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'email', value: "", name: 'email')
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
