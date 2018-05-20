package states;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Optional;

import org.easymock.EasyMock;
import org.junit.Test;

import cards.Card;
import cards.Copper;
import cards.Village;
import gameComponents.Player;

public class VassalPlayStateTest {

	@Test
	public void testPlayStateTopCardNotAction() {
		VassalPlayState state = new VassalPlayState();
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);

		turn.player = player;

		EasyMock.expect(player.discardTopCardOfDrawPile()).andReturn(Optional.of(new Copper()));

		EasyMock.replay(player, turn);

		state.run(turn);

		EasyMock.verify(player, turn);
	}

	@Test
	public void testPlayStateTopCardNotAvailable() {
		VassalPlayState state = new VassalPlayState();
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);

		turn.player = player;

		EasyMock.expect(player.discardTopCardOfDrawPile()).andReturn(Optional.empty());

		EasyMock.replay(player, turn);

		state.run(turn);

		EasyMock.verify(player, turn);
	}

	@Test
	public void testPlayStateTopCardActionChooseNotPlay() {
		VassalPlayState state = new VassalPlayState();
		Card cardToPickUp = new Village();
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);

		turn.player = player;
		turn.state = state;

		EasyMock.expect(player.discardTopCardOfDrawPile()).andReturn(Optional.of(cardToPickUp));
		EasyMock.expect(player.promptYesNo("vassalPrompt")).andReturn(false);

		EasyMock.replay(player, turn);

		state.run(turn);

		assertFalse(turn.state.getClass() == cardToPickUp.getPlayState().getClass());

		EasyMock.verify(player, turn);
	}

	@Test
	public void testPlayStateTopCardActionChoosePlay() {
		VassalPlayState state = new VassalPlayState();
		Card cardToPickUp = new Village();
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);

		turn.player = player;
		turn.state = state;

		EasyMock.expect(player.discardTopCardOfDrawPile()).andReturn(Optional.of(cardToPickUp));
		EasyMock.expect(player.promptYesNo("vassalPrompt")).andReturn(true);
		turn.run();
		EasyMock.expectLastCall();

		EasyMock.replay(player, turn);

		state.run(turn);

		assertEquals(turn.state.getClass(), cardToPickUp.getPlayState().getClass());

		EasyMock.verify(player, turn);
	}

}
