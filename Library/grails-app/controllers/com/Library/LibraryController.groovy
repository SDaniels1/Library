package com.Library

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LibraryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Library.list(params), model:[libraryCount: Library.count()]
    }

    def show(Library library) {
        respond library
    }

    def create() {
        respond new Library(params)
    }

    @Transactional
    def save(Library library) {
        if (library == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (library.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond library.errors, view:'create'
            return
        }

        library.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'library.label', default: 'Library'), library.id])
                redirect library
            }
            '*' { respond library, [status: CREATED] }
        }
    }

    def edit(Library library) {
        respond library
    }

    @Transactional
    def update(Library library) {
        if (library == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (library.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond library.errors, view:'edit'
            return
        }

        library.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'library.label', default: 'Library'), library.id])
                redirect library
            }
            '*'{ respond library, [status: OK] }
        }
    }

    @Transactional
    def delete(Library library) {

        if (library == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        library.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'library.label', default: 'Library'), library.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'library.label', default: 'Library'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
