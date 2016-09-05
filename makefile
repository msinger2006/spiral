JFLAGS = -classpath .

JC = javac

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = spiral.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
