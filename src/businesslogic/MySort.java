package businesslogic;

import java.util.Comparator;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparableComparator;

import common.mydatastructure.SortCell;
import common.statics.Command;
import common.statics.Field;

public class MySort {

	@SuppressWarnings("rawtypes")
	private static Comparator getComparator() {
		Comparator comparator = ComparableComparator.getInstance();
		comparator = ComparatorUtils.nullLowComparator(comparator); // 允许null
		comparator = ComparatorUtils.reversedComparator(comparator); // 允许逆序
		return comparator;

	}

	public static boolean isDescend(String str) {
		if (str.equals(Command.ascend)) {
			return true;
		}
		else {
			return false;
		}
	}

	public static BeanComparator getBeanComparator(SortCell sortCell) {
		if (sortCell.getOrder().equals(Command.ascend)) {
			if (sortCell.getField().equals(Field.GmSc)) {
				return new BeanComparator("gmSc");
			}
			return new BeanComparator(sortCell.getField());
		}
		else {
			if (sortCell.getField().equals(Field.GmSc)) {
				return new BeanComparator("gmSc", getComparator());
			}
			return new BeanComparator(sortCell.getField(), getComparator());
		}
	}
}
