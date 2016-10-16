CC=		g++

OBJS=		strtokenizer.o dataset.o utils.o model.o
MAIN=		edu_lpai_ldawapper_LDAWapper

all:	$(OBJS) $(MAIN).cpp
	$(CC) -fPIC -shared -o $(target_dir)liblda.so -I /opt/java/jdk1.7.0_45/include/ -I /opt/java/jdk1.7.0_45/include/linux/ $(MAIN).cpp $(OBJS)

strtokenizer.o:	strtokenizer.h strtokenizer.cpp
	$(CC) -fPIC -c -o strtokenizer.o strtokenizer.cpp

dataset.o:	dataset.h dataset.cpp
	$(CC) -fPIC -c -o dataset.o dataset.cpp

utils.o:	utils.h utils.cpp
	$(CC) -fPIC -c -o utils.o utils.cpp

model.o:	model.h model.cpp
	$(CC) -fPIC -c -o model.o model.cpp

test:
	

clean:
	rm $(OBJS) 
	rm $(MAIN)

