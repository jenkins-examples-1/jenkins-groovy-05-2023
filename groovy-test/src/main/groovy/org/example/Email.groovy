package org.example

class Email {
    private String message
    private String from
    private String to
    private String subject

    def methodMissing(String name, def args) {
        Closure cl = ((Object[])args)[0]
        cl.setDelegate(this)
        closure.setResolveStrategy(Closure.DELEGATE_FIRST)
        cl.call()
    }

    static def make(Closure closure) {
        EmailDsl emailDsl = new EmailDsl()
        closure.delegate = emailDsl
        closure.setResolveStrategy(Closure.DELEGATE_FIRST)
        closure()
        emailDsl.sendEmail()
    }

    def sendEmail() {
        println("from=${from}, to=${to}, body=${message}")
    }

    def body (String text) {
        message = text
    }

    def from (String text) {
        from= text
    }

    def to (String text) {
        to = text
    }

    def subject (String text) {
        subject = text
    }
}
