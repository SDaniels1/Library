package com.Library

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LibrarianController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Librarian.list(params), model:[librarianCount: Librarian.count()]
    }

    def show(Librarian librarian) {
        respond librarian
    }

    def create() {
        respond new Librarian(params)
    }

    @Transactional
    def save(Librarian librarian) {
        if (librarian == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (librarian.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond librarian.errors, view:'create'
            return
        }

        librarian.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'librarian.label', default: 'Librarian'), librarian.id])
                redirect librarian
            }
            '*' { respond librarian, [status: CREATED] }
        }
    }

    def edit(Librarian librarian) {
        respond librarian
    }

    @Transactional
    def update(Librarian librarian) {
        if (librarian == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (librarian.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond librarian.errors, view:'edit'
            return
        }

        librarian.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'librarian.label', default: 'Librarian'), librarian.id])
                redirect librarian
            }
            '*'{ respond librarian, [status: OK] }
        }
    }

    @Transactional
    def delete(Librarian librarian) {

        if (librarian == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        librarian.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'librarian.label', default: 'Librarian'), librarian.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

def login(){
	if (params.cName)
		return[cName:params.cName, aName:params.aName]
	}

def validate() {
 	def user = Leader.findByUserName(params.username)
 	if (user && user.password == params.password){
 		session.user = user
 		if (params.cName)
 	redirect controller:params.cName, action:params.aName
 else
 	redirect controller:'course', action:'index'
 } else{

 flash.message = "Invalid username and password."

 render view:'login'
 	}
 }

def logout = {
 	session.user = null
 	redirect(uri:'/')
 }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'librarian.label', default: 'Librarian'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
