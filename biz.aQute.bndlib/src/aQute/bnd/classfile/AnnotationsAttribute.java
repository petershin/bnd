package aQute.bnd.classfile;

import java.io.DataInput;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Function;

public abstract class AnnotationsAttribute implements Attribute {
	public final AnnotationInfo[] annotations;

	AnnotationsAttribute(AnnotationInfo[] annotations) {
		this.annotations = annotations;
	}

	@Override
	public String toString() {
		return name() + " " + Arrays.toString(annotations);
	}

	static <A extends AnnotationsAttribute> A read(DataInput in, ConstantPool constant_pool,
		Function<AnnotationInfo[], A> constructor) throws IOException {
		AnnotationInfo[] annotations = AnnotationInfo.readInfos(in, constant_pool);
		return constructor.apply(annotations);
	}
}
