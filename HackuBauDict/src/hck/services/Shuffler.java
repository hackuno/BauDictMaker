package hck.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import org.junit.platform.commons.util.StringUtils;

import hck.enums.JunctionMode;
import hck.enums.UpLowMode;

public class Shuffler {

	private Set<String> sym = new HashSet<String>();
	private Metamorpher m = new Metamorpher();

	public Shuffler(String... symbols) {
		for (String s : symbols) {
			sym.add(s);
		}
		sym.add("");
	}

	public Shuffler(Set<String> symbols) {
		sym = symbols;
		sym.add("");
	}

	public Shuffler() {
	}

	public void cardinality1(List<List<String>> listona, UpLowMode ulMode, JunctionMode jMode) {
		cardinality1(listona, ulMode, jMode, null, null);
	}

	public void cardinality1(List<List<String>> listona, UpLowMode ulMode, JunctionMode jMode, String testFindMe,
			ConcurrentSkipListSet<String> ctrl) {

		Finalizer F = new Finalizer(ctrl);

		for (List<String> blk1 : listona) {
			blk1.parallelStream().flatMap(f -> m.upperLower(f, ulMode)).flatMap(x -> Junction.junction(jMode, sym, x))
					.filter(y -> StringUtils.isBlank(testFindMe) ? true : y.equals(testFindMe)).forEach(r -> {
						F.finalize(r);

					});
		}

	}

	public void cardinality2(List<List<String>> listona, UpLowMode ulMode, JunctionMode jMode) {
		cardinality2(listona, ulMode, jMode, null, null);
	}

	public void cardinality2(List<List<String>> listona, UpLowMode ulMode, JunctionMode jMode, String testFindMe,
			ConcurrentSkipListSet<String> ctrl) {

		Finalizer F = new Finalizer(ctrl);

		// cardinality 2s
		int i = 0;
		for (List<String> blk1 : listona) {
			int ii = 0;
			for (List<String> blk2 : listona) {
				if (i != ii) {
					blk2.parallelStream().flatMap(f -> m.upperLower(f, ulMode)).forEach(y -> blk1.parallelStream()
							.flatMap(f -> m.upperLower(f, ulMode)).flatMap(x -> Junction.junction(jMode, sym, x, y))
							.filter(x -> StringUtils.isBlank(testFindMe) ? true : x.equals(testFindMe)).forEach(r -> {
								F.finalize(r);

							}));
				}
				ii++;
			}
			i++;
		}

	}

	public void cardinality3(List<List<String>> listona, UpLowMode ulMode, JunctionMode jMode) {
		cardinality3(listona, ulMode, jMode, null, null);
	}

	public void cardinality3(List<List<String>> listona, UpLowMode ulMode, JunctionMode jMode, String testFindMe,
			ConcurrentSkipListSet<String> ctrl) {

		Finalizer F = new Finalizer(ctrl);

		// cardinality 3
		int a = 0;
		for (List<String> blk1 : listona) {
			int aa = 0;
			for (List<String> blk2 : listona) {
				if (a != aa) {
					int aaa = 0;
					for (List<String> blk3 : listona) {
						if (aaa != aa && aaa != a) {
							blk3.parallelStream().flatMap(f -> m.upperLower(f, ulMode)).forEach(z -> blk2
									.parallelStream().flatMap(f -> m.upperLower(f, ulMode))
									.forEach(y -> blk1.parallelStream().flatMap(f -> m.upperLower(f, ulMode))
											.flatMap(x -> Junction.junction(jMode, sym, x, y, z))
											.filter(x -> StringUtils.isBlank(testFindMe) ? true : x.equals(testFindMe))
											.forEach(r -> {
												F.finalize(r);

											})));

						}
						aaa++;
					}

				}
				aa++;

			}
			a++;

		}

	}

	public void cardinality4(List<List<String>> listona, UpLowMode ulMode, JunctionMode jMode) {
		cardinality4(listona, ulMode, jMode, null, null);
	}

	public void cardinality4(List<List<String>> listona, UpLowMode ulMode, JunctionMode jMode, String testFindMe,
			ConcurrentSkipListSet<String> ctrl) {

		Finalizer F = new Finalizer(ctrl);

		// cardinality 4
		int a = 0;
		for (List<String> blk1 : listona) {
			int aa = 0;
			for (List<String> blk2 : listona) {
				if (a != aa) {
					int aaa = 0;
					for (List<String> blk3 : listona) {
						if (aaa != aa && aaa != a) {
							int aaaa = 0;
							for (List<String> blk4 : listona) {
								if (aaaa != aaa && aaaa != aa && aaaa != a) {
									blk4.parallelStream().flatMap(f -> m.upperLower(f, ulMode)).forEach(q -> blk3
											.parallelStream().flatMap(f -> m.upperLower(f, ulMode))
											.forEach(z -> blk2.parallelStream().flatMap(f -> m.upperLower(f, ulMode))
													.forEach(y -> blk1.parallelStream()
															.flatMap(f -> m.upperLower(f, ulMode))
															.flatMap(x -> Junction.junction(jMode, sym, x, y, z, q))
															.filter(x -> StringUtils.isBlank(testFindMe) ? true
																	: x.equals(testFindMe))
															.forEach(r -> {
																F.finalize(r);

															}))));
								}
								aaaa++;
							}

						}
						aaa++;
					}

				}
				aa++;

			}
			a++;

		}

	}

	public void cardinality5(List<List<String>> listona, UpLowMode ulMode, JunctionMode jMode) {
		cardinality5(listona, ulMode, jMode, null, null);
	}

	public void cardinality5(List<List<String>> listona, UpLowMode ulMode, JunctionMode jMode, String testFindMe,
			ConcurrentSkipListSet<String> ctrl) {

		Finalizer F = new Finalizer(ctrl);

		// cardinality 4
		int a = 0;
		for (List<String> blk1 : listona) {
			int aa = 0;
			for (List<String> blk2 : listona) {
				if (a != aa) {
					int aaa = 0;
					for (List<String> blk3 : listona) {
						if (aaa != aa && aaa != a) {
							int aaaa = 0;
							for (List<String> blk4 : listona) {
								if (aaaa != aaa && aaaa != aa && aaaa != a) {
									int aaaaa = 0;
									for (List<String> blk5 : listona) {
										if (aaaaa != aaaa && aaaaa != aaa && aaaaa != aa && aaaaa != a) {
											blk5.parallelStream().flatMap(f -> m.upperLower(f, ulMode))
													.forEach(r -> blk4.parallelStream()
															.flatMap(f -> m.upperLower(f, ulMode))
															.forEach(q -> blk3.parallelStream()
																	.flatMap(f -> m.upperLower(f, ulMode))
																	.forEach(z -> blk2.parallelStream()
																			.flatMap(f -> m.upperLower(f, ulMode))
																			.forEach(y -> blk1.parallelStream()
																					.flatMap(f -> m.upperLower(f,
																							ulMode))
																					.flatMap(x -> Junction.junction(
																							jMode, sym, x, y, z, q, r))
																					.filter(x -> StringUtils
																							.isBlank(testFindMe)
																									? true
																									: x.equals(
																											testFindMe))
																					.forEach(rx -> {
																						F.finalize(rx);

																					})))));
										}
										aaaaa++;
									}

								}
								aaaa++;
							}

						}
						aaa++;
					}

				}
				aa++;

			}
			a++;

		}

	}

}
