package gameMonsters;

public class Monster_Goblin extends SuperMonster{
	public Monster_Goblin() {

		setName("Goblin");
		setLevel(2);
		setCurrentHp(10);
		setMaxHp(10);
		setMonsterGold(2);
		setMonsterDamage(1);

		getLootTable().add(getFactories().createWeapon("Dagger"));
		getLootTable().add(getFactories().createWeapon("Sword"));
		getLootTable().add(getFactories().createConsumable("HpPotion"));


	}
}
